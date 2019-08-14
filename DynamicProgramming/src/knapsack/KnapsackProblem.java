package knapsack;

/**
 * 背包问题
 * 每次遍历到的第i个物品,根据w[i]和v[i]来确定是否需要将物品放入背包中.
 * 即对于给定的n个物品,设v[i],w[i]分别为第i个物品的价值和重量,C为背包容量.
 * 再令v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值,则我们有下面的结果:
 * <p>
 * 1. v[i][0]=v[0][j]=0;   //表示填入第一行和第一列是0
 * 2. 当w[i]>j时:v[i][j]=v[i-1][j];  //当准备加入新增商品的容量大于当前背包的容量时,就直接使用上一个单元的装入策略
 * 3. 当j>=w[i]时:v[i][j]=max{v[i-1][j] , v[i-1][j-w[i]]+v[i]}  //当准备加入的新增商品的容量小于等于当前背包的容量,
 * 装入的方式:
 * v[i-1][j] : 就是上一个单元格的装入最大值
 * v[i-1][j-w[i]]+v[i] :
 * v[i]:当前商品的价值
 * v[i-1][j-w[i]] : 装入i-1个商品,到剩余空间的最大值
 * v[i-1]:不包括当前的商品
 * j-w[i];剩余的重量
 * <p>
 * <p>
 * v[i][j]即背包的填表
 * v[i][j]中的j列表示:  当容量固定为某个值
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {3,4,1}; //物品的重量
        int[] val = {2000,3000,1500}; //单个物品的价值
        int m = 4; //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组
        int[][] v = new int[n + 1][m + 1];


        //为了记录放入商品的情况,我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //根据前面的公式来动态规划处理
        for (int i = 1; i < v.length; i++) { //不处理第一行
            for (int j = 1; j < v[0].length; j++) { //不处理第一列
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品被存放到背包的情况,我们不能使用上面的Math.max(),要使用if-else
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];

                        //把当前的情况记录到path
                        path[i][j] = 1;

                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }


        //输出一下v 看看目前的情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        //输出最后我们放入的商品有哪些
        //遍历path,这样输出会把所有的放入情况都得到,其实我们只需要最后的放入
//        for (int i = 0; i < path.length; i++) {
//            for(int j=0;j<path[i].length;j++){
//                if (path[i][j] == 1) {
//                    System.out.printf("第%d个商品放入到背包\n",i);
//                }
//            }
//        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }

    }
}
