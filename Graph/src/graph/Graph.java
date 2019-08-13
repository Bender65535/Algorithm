package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    //存储定点的值
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;

    public static void main(String[] args) {
        String[] vertexs={"A","B","C","D","E"};

        //创建图对象
        Graph graph=new Graph(5);
        //循环添加节点
        for(String vertex:vertexs){
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();

        //测试dfs
        System.out.println("深度遍历");
//        graph.dfs();

        //测试bfs
        System.out.println("广度优先遍历");
        graph.bfs();
    }

    public Graph(int n){
        //初始化矩阵vertexList
        edges=new int[n][n];
        vertexList =new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    /**
     * 插入定点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }



    /**
     * 添加图中常用的方法
     */

    /**
     * 返回边的个数
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回节点的个数
     */
    public int getNumofVertex(){
        return vertexList.size();
    }

    /**
     * 返回节点i(下标)对应的数据 0->A
     * @param i
     * @return
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1和v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }


    /**
     * dfs
     * 1.访问初始节点v,并标记节点v为已访问
     * 2.查找节点v的第一个邻接节点w
     * 3.若w存在,则继续执行4,如果w不存在,则回到第1步,将从v的下一个节点继续
     * 4.若w未被访问,对w进行深度优先遍历递归(即把w当做另一个v,然后进行步骤123)
     * 5.若w已被访问,查找节点v的w邻接节点的下一个邻接节点,转到步骤3
     *
     * @param isVisited
     * @param v 初始节点
     */
    public void dfs(boolean[] isVisited,int v){
        //1.访问初始节点
        System.out.print(getValueByIndex(v)+"->");
        //将该节点设置为已经访问
        isVisited[v]=true;

        //2.访问第一个邻接节点
        int w=getFirstNeighbor(v);

        while (w!=-1){//说明w存在,有邻接节点
            //4.节点未被访问
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //w被访问过
            w=getNextNeighbor(v,w);

        }
    }

    /**
     * 对dfs进行重载,遍历所有的节点,并进行dfs
     */
    public void dfs(){
        for(int i=0;i<getNumofVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
                System.out.println(Arrays.toString(isVisited));
            }
        }
    }

    //定义数组boolean[],记录某个节点是否被访问过
    private boolean[] isVisited;

    /**
     * 得到第一个邻接节点的下标w
     * @return
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexList.size();j++){
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v1 表示当前的节点
     * @param v2 表示当前节点的邻接节点
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }


    /**
     * bfs
     *
     * 1.访问初始节点v并标记节点v为已访问
     * 2.节点v入队列
     * 3.当队列非空时,继续执行,否则算法结束
     * 4.出队列,取得队头节点u
     * 5.查找节点u的第一个邻接节点w
     * 6.若节点u的邻接节点w不存在,则转到步骤3;否则循环执行以下三个步骤:
     * 6.1若节点w尚未被访问,则访问节点w并标记为已访问
     * 6.2节点w入队列
     * 6.3查找节点u的继w邻接节点后的下一个邻接节点w,转到步骤6
     *
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited , int i){
        int u; //表示队列的头节点对应的下标
        int w; //邻接节点w
        //队列,记录节点访问的顺序
        LinkedList queue=new LinkedList();
        //访问节点,输出节点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列的头节点下标
            u=(Integer)queue.removeFirst();
            //得到第一个邻接节点的下标w
            w=getFirstNeighbor(u);

            while (w!=-1){//邻接节点存在
                //是否访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    //标记被访问过
                    isVisited[w]=true;
                    //加入队列
                    queue.addLast(w);
                }
                //以u为前驱节点,找w后面的下一个节点
                w=getNextNeighbor(u,w);  //这部提现了广度优先
            }
        }
    }

    /**
     * 遍历所有的节点,都进行广度优先遍历
     */
    public void bfs(){
        for(int i=0;i<getNumofVertex();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
