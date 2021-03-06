import java.util.Arrays;

/**
 * kmp
 * 1.先得到子串的部分匹配表
 * 2.使用部分比配表完成kmp匹配
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "bbc abcdab abcdabcdabde";
        String str2 = "abcdabd";

        int[] next = kmpNext("abcdabd");
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }


    /**
     * kmp搜索算法
     *
     * @param str1 原字符串
     * @param str2 子串
     * @param next 部分匹配表
     * @return 如果是-1就是没有匹配到,否则返回一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i) != str2.charAt(j)
            //kmp算法核心
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {  //找到了 j=3,i=2
                return i - j + 1;
            }


        }
        return -1;
    }

    /**
     * 获取到一个字符串(子串)的部分匹配值表
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1部分匹配就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {   //j代表公共前后缀长度
            //当dest.charAt(i) != dest.charAt(j),我们需要从next[j-1]获取新的j
            //直到我们发现有dest.charAt(i)==dest.charAt(j)成立才退出
            //这是kmp算法的核心
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                //aab aaa
                /*
                比如说 abc abd
                在比较abd失败了,就要尝试比较bd,所以要查看有没b结尾的前缀
                abab sdfjsdlflsf ababab
                 */
                j = next[j - 1];  //回溯(动态规划)
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时,部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                //如果i和j相等,i和j共同+1
                j++;
            }

            next[i] = j;
        }
        return next;
    }
}
