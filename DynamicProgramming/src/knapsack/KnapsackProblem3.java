package knapsack;

/**
 * 空间复杂度优化
 * dp时只用到了两个状态:n 和 n-1
 * 所以只需要使用两个数组
 * <p>
 * 可以使用滚动数组:
 * 第一维只维护两个:F[i&1][] F[(i-1)&1][]
 * <p>
 * 一维数组与倒序遍历
 */
public class KnapsackProblem3 {
    public static void main(String[] args) {
        int[] w = {3, 4, 1}; //物品的重量
        int[] val = {2000, 3000, 1500}; //单个物品的价值
        int c = 4; //背包的容量
        int n = val.length; //物品的个数

        int[][] v = new int[2][c + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= c; j++) {
                if (i < 1) {
                    v[i][j] = w[i] <= j ? val[i] : 0;
                } else {
                    v[i & 1][j] = v[(i - 1) & 1][j];
                    if (w[i] <= j) {
                        v[i & 1][j] = Math.max(v[(i - 1) & 1][j], val[i] + v[(i - 1) & 1][j - w[i]]);
                    }
                }
            }
        }
        //从第0个算起, 要-1
        System.out.println("最大价值为:" + v[(n - 1) & 1][c]);
    }
}
