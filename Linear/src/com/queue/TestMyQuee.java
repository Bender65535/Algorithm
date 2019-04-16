package com.queue;

public class TestMyQuee {
    public static void main(String[] args) {
        Myqueue mq=new Myqueue();
        mq.add(3);
        mq.add(2);
        mq.add(5);
        mq.add(1);
        mq.add(78);
        mq.add(155);
        mq.add(23);
        mq.show();

        System.out.println();
        mq.poll();
        mq.poll();
        mq.show();
    }
}
