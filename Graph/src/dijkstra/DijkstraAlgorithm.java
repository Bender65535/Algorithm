package dijkstra;

import java.util.Arrays;

/**
 * Dijkstra算法
 * 设置出发顶点为v,顶点集合V{v1,v2,vi...},v到V中各顶点的距离构成距离集合Dis,
 * Dis{d1,d2,di},Dis集合记录看v到图中各顶点的距离(到自身可以看做0,v到vi距离对应di)
 * 1.从Dis中选择值最小的di并移出Dis集合,同时移出V集合中对应的顶点vi,此时的v到vi即为最短路径
 * 2.跟新Dis集合,更新规则为:比较v到V集合中顶点的距离值,与v通过vi到V集合中顶点的距离值
 *   保留值较小的一个(同时也应该更新顶点的前驱节点为vi,表明是通过vi到达的)
 * 3.重复执行两步骤,直到最短路径顶点为目标顶点即可结束
 *
 * Dijkstra使用的是广度优先遍历
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int[][] matrix=new int[vertex.length][vertex.length];
        final int N=65535;

        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        Graph graph=new Graph(vertex,matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();
    }
}

class Graph{
    private char[] vertex; //顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv;  //已经访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showDijkstra(){
        vv.show();
    }

    public void showGraph(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * dijkstra算法实现
     * @param index 表示出发点对应的下标
     */
    public void dsj(int index){
        vv= new VisitedVertex(vertex.length, index);
        update(index); //更新index顶点到周围顶点的距离和前驱顶点
        for(int j=1;j<vertex.length;j++){
            index=vv.updateArr(); //选择并返回新的访问节点
            update(index); //更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    private void update(int index){
        int len=0;
        for (int j = 0; j < matrix[index].length; j++) {
            //len: 出发顶点到index顶点的距离,+从index顶点到j顶点的距离的和
            len=vv.getDis(index)+matrix[index][j];
            //如果j顶点没有被访问过,并且len小于出发顶点到j顶点的距离,就需要更新
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j,index); //更新j顶点的前驱为index顶点
                vv.updateDis(j,len); //更新出发顶点到j顶点的距离
            }
        }
    }
}


/**
 * 已访问顶点合集
 */
class VisitedVertex{
    public int[] already_arr; //记录各个顶点是否访问过
    public int[] pre_visited; //每个下标对应的值为前一个顶点下标,会动态更新
    public int[] dis;  //出发顶点到index的距离

    /**
     *
     * @param length 表示顶点个数
     * @param index 出发顶点对应的下标
     */
    public VisitedVertex(int length, int index){
        this.already_arr=new int[length];
        this.pre_visited=new int[length];
        this.dis=new int[length];
        //初始化dis数组
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;
        this.dis[index]=0;
    }

    /**
     * 判断index顶点是否被访问过
     * @param index
     * @return 如果访问过,就返回true
     */
    public boolean in(int index){
        return already_arr[index]==1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index]=len;
    }

    /**
     * 更新顶点的前驱为index节点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre]=index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index){
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点,比如这里的G完后,就是A点作为新的访问顶点(注意不是出发顶点)
     * @return
     */
    public int updateArr(){
        int min=65535,index=0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) { //判断上一步中所找到的最短路径是哪条
                min=dis[i];
                index=i;
            }
        }
        //更新index顶点被访问过
        already_arr[index]=1;
        return index;
    }

    /**
     * 显示最后结果
     * 即三个数组的情况输出
     */
    public void show(){
        System.out.println("==============================");
        System.out.println("输出already_arr");
        for(int i: already_arr){
            System.out.print(i+" ");
        }
        System.out.println("\n输出pre_visited");
        for (int i: pre_visited){
            System.out.print(i + " ");
        }
        System.out.println("\n输出dis");
        for (int i:dis){
            System.out.print(i+" ");
        }
    }

}
