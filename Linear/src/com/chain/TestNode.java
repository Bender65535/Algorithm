package com.chain;

public class TestNode {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.append(n2).append(n3).append(new Node(4));

        System.out.println(n1.next().getData());
        System.out.println(n2.next().getData());
        System.out.println(n1.next().next().next().getData());
        System.out.println(n1.next().next().isLast());

        System.out.println("============");
        n1.removeNext();
        System.out.println(n1.next.getData());
        System.out.println("============");
        System.out.println();
        System.out.println("============");

        Node n5=new Node(5);
        n3.after(n5);
        n1.show();
    }
}
