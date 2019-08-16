package prim;

import java.util.Arrays;

/**
 * 最小生成树:
 * 1.给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小,,这叫最小生成树
 * 2.N个顶点,一定有N-1条边
 * 3.包含全部顶点
 * 4.N-1条边在图中
 * 5.最小生成树的算法主要是普里姆算法和克鲁斯卡尔算法
 * <p>
 * <p>
 * 普里姆算法:
 * 1.设G=(V,E)是连通网,T=(U,D)是最小生成树,V,U是顶点集合,E,D是边的集合
 * 2.若从顶点u开始构造最小生成树,则从集合V中取出顶点u放入集合U中,标记顶点v的visited[u]=1
 * 3.若集合U中顶点ui与集合V-U中的顶点vj之间存在边,则寻找这些边中权值最小的边,但不能构成回路,将顶点vj加入集合U中,将边(ui,vj)加入集合D中,标记visited[vj]=1
 * 4.重复步骤2,直到U与V相等,即所有顶点都被标记访问过,此时D中有n-1条边
 */
public class PrimAlgorithem {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示
        int[][] weight = new int[][]{  //10000表示不连通
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph graph = new MGraph(verxs);
        //创建MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
        minTree.showGraph(graph);

        //测试普里姆算法
        minTree.prim(graph,0);
    }
}

/**
 * 创建最小生成树->村庄的图
 */
class MinTree {
    //创建图的邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 显示邻接矩阵
     * @param graph
     */
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 编写prim算法
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成 'A'->0
     */
    public void prim(MGraph graph,int v){
        //visited[] 标记节点是否被访问过
        int visited[] =new int[graph.verxs];

        //把当前这个点标记为已访问
        visited[v]=1;
        //h1 和 h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        //将minWeight初始成一个大数,后面在遍历过程中,会被替换
        int minWeight=10000;

        //因为有graph.verxs个顶点,普里姆算法结束后,有graph.verxs条边
        for (int k=1;k<graph.verxs;k++){

            //遍历每个顶点,确定每一次生成的子图和哪个节点的距离最近
            for(int i=0;i<graph.verxs;i++){
                for (int j=0;j<graph.verxs;j++){
                    //遍历当前节点是否与其他节点连通,并且,找出minWeight
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }

            //找到一条边是最小
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值:"+minWeight);
            //将当前这个节点标记为已经访问
            visited[h2]=1;
            //minWeight重新设置为最大值
            minWeight=10000;

        }
    }

}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data; //存放节点数据
    int[][] weight; //存放边,邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}