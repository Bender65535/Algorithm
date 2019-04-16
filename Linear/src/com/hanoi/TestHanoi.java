package com.hanoi;

public class TestHanoi {
    public static void main(String[] args) {
        hanoi(1,'A','B', 'C');
        System.out.println("========");
        hanoi(2,'A','B', 'C');
        System.out.println("========");
        hanoi(3,'A','B', 'C');
        System.out.println("========");
        hanoi(4,'A','B', 'C');


    }

//    n个盘子,开始的盘子from,中间的盘子in,目标的盘子to
    public static void hanoi(int n,char from,char in,char to){
        if(n==1){
            System.out.println("第1个盘子从"+from+"移动到"+to);
        }
        else {
            hanoi(n-1,from,to, in);
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            hanoi(n-1,in,from, to);
        }
    }
}
