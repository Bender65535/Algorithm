package kruskal;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法
 * 是用来求加权连通图的最小生成树算法
 *
 * 基本思想:按照权值从小到大的顺序选择n-1条边,并保证n-1条边不构成回路
 *
 * 具体做法:首先构造一个只含n个顶点的森林,然后依权值从小到大从连通网中选择边加入到森林中,并使森林中不产生回路,直至森林变成一棵树为止
 *
 * E,F  C,D  D,E 加入到最小生成树R中后,这几条边就有了终点:
 *  C的终点是F;  D的终点是F;  E的终点是F;  F的终点是F  此时若将C,E加入森林,则构成回路(我们加入的边的两个顶点不能指向同一个终点)
 */
public class KruskalCase {
    private int edgeNum; //能够连通的边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        //克鲁斯卡尔邻接矩阵
        int matrix[][]={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        //创建KruskalCase对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();

        //排序
        EData[] edges = kruskalCase.getEdges();
        kruskalCase.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));

        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs,int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen=vertexs.length;

        //初始化顶点
        this.vertexs=new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i]=vertexs[i];
        }

        //初始化边
        this.matrix=new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen; i++) {

            //防止统计到自己连接自己的边
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 克鲁斯卡尔算法
     */
    public void kruskal(){
        int index=0; //表示最后结果数组的索引

        //用于保存"已有最小生成树"中的每个顶点在最小生成树的终点
        int[] ends=new int[edgeNum];
        //创建结果数组,保存最后的最小生成树
        EData[] rets = new EData[vertexs.length-1];

        //获取图中所有的边的集合
        EData[] edges=getEdges();

        //按照边的权值大小尽心排序
        sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        //遍历edges数组,将边添加到最小生成树中时,判断是否形成回路,如果没有,加入到rets
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的第一个顶点
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树中的终点
            int m=getEnd(ends,p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n=getEnd(ends,p2);
            //是否构成回路
            if (m != n) {
                //设置m在"已有最小生成树"中的终点
                ends[m]=n;
                //有一条边加入到rets数组
                rets[index++]=edges[i];
            }
        }

        //统计并打印"最小生成树",输出rets
        System.out.println("最小生成树为:\n"+Arrays.toString(rets));
    }

    /**
     * 打印邻接矩阵
     */
    public void print(){
        System.out.println("邻接矩阵为:\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 功能:对边进行排序处理,冒泡排序
     * @param edges 边的集合
     */
    public void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-1; j++) {
                if(edges[j].weight>edges[j+1].weight){
                    EData tmp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=tmp;
                }
            }
        }
    }

    /**
     *
     * @param ch
     * @return 返回ch顶点对应的下标,如果找不到返回-1
     */
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边,放到EData[]数组中,后面我们需要遍历该数组
     * @return
     */
    private EData[] getEdges(){
        int index=0;
        EData[] eData = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    eData[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }

        return eData;
    }

    /**
     * 获取下标i的顶点的终点,用于判断两个顶点的终点是否相同
     * @param ends 数组就是记录了各个顶点的终点是哪个,ends数组是在遍历过程中,逐步形成的
     * @param i 传入的顶点对应的下标
     * @return 下标i顶点所对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0) {
            i=ends[i];
        }
        return i;
    }
}
class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start +
                ", end=" + end +
                ">weight=" + weight +"\n";
    }
}