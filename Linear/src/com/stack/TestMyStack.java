package com.stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(22);
        stack.push(13);
        stack.push(1234);
        stack.push(54);
        stack.push(13);
        stack.push(52);
        stack.show();

        System.out.println();

        int pop =stack.pop();
        System.out.println("出栈:"+pop);
        pop =stack.pop();
        System.out.println("出栈:"+pop);
        pop =stack.pop();
        System.out.println("出栈:"+pop);
        pop =stack.pop();
        System.out.println("出栈:"+pop);
        System.out.println();
        stack.show();
        System.out.println();
    }
}
