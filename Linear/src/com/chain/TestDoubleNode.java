package com.chain;

public class TestDoubleNode {
    public static void main(String[] args) {
        DoubleNode d1=new DoubleNode(1);
        DoubleNode d2=new DoubleNode(2);
        DoubleNode d3=new DoubleNode(3);
        DoubleNode d4=new DoubleNode(4);

        d1.after(d2);
        d2.after(d3);
        d3.after(d4);
        System.out.println(d1.pre.data);
        System.out.println(d1.next.data);
        System.out.println();
        System.out.println(d2.pre.data);
        System.out.println(d2.next.data);
        System.out.println();
        System.out.println(d3.pre.data);
        System.out.println(d3.next.data);
        System.out.println();
        System.out.println(d4.pre.data);
        System.out.println(d4.next.data);
        System.out.println();


    }


}
