package knapsack;

/**
 * 优化:
 * 一维数组与倒序遍历
 *
 * 其实每次比较的都是F[i - 1][j] 与 F[i - 1][j - w[i]] + val[i]
 * 也就是用到的数据都是上一阶段的
 *
 * 如果使用正序的话, 靠前的数据就会被更新, 靠后的数据就不是与上一阶段的数据作比较, 而是与现在这一阶段的数据作比较
 */
public class KnapsackProblem4 {
    public static void main(String[] args) {
        int[] w = {3, 4, 1}; //物品的重量
        int[] val = {2000, 3000, 1500}; //单个物品的价值
        int c = 4; //背包的容量
        int n = val.length; //物品的个数

        int[] v = new int[c + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = c; j >= 0; j--) {

                if (w[i] <= j) {
                    v[j] = Math.max(v[j], val[i] + v[j - w[i]]);
                }
            }
        }
        //从第0个算起, 要-1
        System.out.println("最大价值为:" + v[c]);
    }
}
