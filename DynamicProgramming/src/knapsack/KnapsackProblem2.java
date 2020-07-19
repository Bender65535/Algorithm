package knapsack;

/**
 * 背包问题
 * 每次遍历到的第i个物品,根据w[i]和val[i]来确定是否需要将物品放入背包中.
 * 即对于给定的n个物品,设val[i],w[i]分别为第i个物品的价值和重量,C为背包容量.
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
public class KnapsackProblem2 {
    public static void main(String[] args) {
        int[] w = {3,4,1}; //物品的重量
        int[] val = {2000,3000,1500}; //单个物品的价值
        int c = 4; //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组
        int[][] v = new int[n][c+1];



        //根据前面的公式来动态规划处理
        for (int i = 0; i < v.length; i++) { //不处理第一行
            for (int j = 0; j < v[0].length; j++) { //不处理第一列
                if (i < 1){
                    v[i][j] = w[i] <= j ? val[i]:0;
                }else {
                    v[i][j] = v[i - 1][j];
                    //加入当前物品的重量大于j,则当前最大值选取上一阶段的,也就是不选取该物品
                    if (w[i] <= j) {
                        v[i][j] = Math.max(v[i-1][j],val[i]+v[i-1][j-w[i]]);
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.printf("  %4d ",v[i][j]);
            }
            System.out.println();
        }

    }
}
