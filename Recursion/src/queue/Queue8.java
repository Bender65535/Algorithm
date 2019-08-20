package queue;

import java.util.Arrays;

/**
 * 八皇后问题
 * 1.第一个皇后放在第一行第一列
 * 2.第二个皇后放在第二行第一列,然后判断是否ok(即判断是否冲突),如果不ok,继续放在第二列,第三列,依次把所有列都放完
 * 3.继续第三个皇后,还是第一列,第二列......知道第8个皇后也能放在一个不冲突的位置,算是找到了一个正确解
 * 4.当得到一个正确解时,在栈回退到上一个栈时,就会开始回溯,即将第一个皇后,放到第一列的所有正确解,全部得到
 * 5.然后回头继续第一个皇后放第二列,后面继续循环执行1,2,3,4的步骤
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max=8;
    int[] array=new int[max];
    static int count=0;
    static int judgeCount;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("共有"+count+"种解法");
        System.out.println("共判断了"+judgeCount+"次冲突");

    }

    private void check(int n){
        if (n == max) {
            print();
            count++;
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后n放到改行的第1列
            array[n]=i;
            //判断当前放置第n个皇后到i列时,是否冲突
            if (judge(n)) { //不冲突
                //接着放n+1个皇后
                check(n+1);
            }
            //如果冲突,就继续执行array[n]=i;即将第n个皇后放在本行的后移一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后,就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //表示两个点在同一列或同一对斜线上
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print(){
        System.out.println(Arrays.toString(array));
    }
}
