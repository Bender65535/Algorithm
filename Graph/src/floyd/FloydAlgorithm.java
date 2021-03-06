package floyd;

import java.util.Arrays;

/**
 * 1.设置顶点vi到顶点vk的最短路径,已知Lik(i到k的长度) 顶点vk到vj的最短路径已知为Lkj,
 * 顶点vi到vj的路径为Lij,则vi到vj的最短路径为:min((Lik+Lkj),Lij),vk的取指为图中所有顶点,
 * 则可获得vi到vj的最短路径
 * 2.至于vi到vk的最短路径Lik或者vk到vj的最短路径Lkj,是以同样的方式获得
 *
 * 步骤:
 * 第一轮循环中,以A(下标为0)作为中间顶点(即把A作为中间顶点的所有情况进行遍历,就会得到更新距离表和前驱关系)
 * 将A作为中间顶点情况有:C-A-G C-A-B G-A-B,则要更新CG,CB,GB的距离表
 */
public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int[][] matrix=new int[vertex.length][vertex.length];
        final int N=65535;

        matrix[0]=new int[]{0,5,7,N,N,N,2};
        matrix[1]=new int[]{5,0,N,9,N,N,3};
        matrix[2]=new int[]{7,N,0,N,8,N,N};
        matrix[3]=new int[]{N,9,N,0,N,4,N};
        matrix[4]=new int[]{N,N,8,N,0,5,4};
        matrix[5]=new int[]{N,N,N,4,5,0,6};
        matrix[6]=new int[]{2,3,N,N,4,6,0};

        Graph graph=new Graph(vertex.length,matrix,vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph{
    private char[] vertex; //存放顶点的数组
    private int[][] dis; //保存,从各个顶点出发到其他顶点的距离,最后的结果,也是保留在数组
    private int[][] pre; //保存到达目标顶点的前驱顶点

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length,int[][] matrix,char[] vertex){
        this.vertex=vertex;
        this.dis=matrix;
        this.pre=new int[length][length];
        //对pre数组初始化,注意,存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    /**
     * 显示pre数组和dis数组
     */
    public void show(){
        char[] vertex={'A','B','C','D','E','F','G'};
        for (int k = 0; k < dis.length; k++) {
            //先将pre数组输出
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]]+" ");
            }
            System.out.println();
            //dis
            for (int i = 0; i < dis.length; i++) {
                System.out.print(" ("+vertex[k]+"到"+vertex[i]+"的最短路径是"+dis[k][i]+")  ");
            }

            System.out.println();
            System.out.println();
        }

    }

    /**
     * 弗洛伊德算法
     */
    public void floyd(){
        int len=0;
        //从中间顶点遍历,k就是中间顶点的下标{'A','B','C','D','E','F','G'}
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发{'A','B','C','D','E','F','G'}
            for (int i = 0; i < dis.length; i++) {
                //j为终点
                for (int j = 0; j < dis.length; j++) {
                    //求出i顶点出发,经过k中间顶点,到达j顶点距离
                    len=dis[i][k]+dis[k][j];

                    if(len<dis[i][j]){
                        //如果len小瑜dis[i][j](直连距离),就更新距离
                        dis[i][j]=len;
                        //更新前驱顶点为当前中间顶点
                        pre[i][j]=pre[k][j];
                    }
                }
            }
        }
    }
}
