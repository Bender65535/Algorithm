package com.chain;

public class DoubleNode {
    DoubleNode pre=this;
    DoubleNode next=this;

    int data;

    public DoubleNode(int data){
        this.data=data;
    }

    public void after(DoubleNode node){
        DoubleNode Next=this.next;
        this.next=node;
        node.next=Next;
        node.pre=this;
        Next.pre=node;
    }

    public DoubleNode getNext(){
        return this.next;
    }

    public DoubleNode getPre() {
        return this.pre;
    }
}
