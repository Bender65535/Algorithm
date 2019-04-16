package com.chain;

public class LoopNode {
    int data;
//    如果只有一个,next为this
    LoopNode next=this;

    public LoopNode(int data){
        this.data=data;
    }


    public void removeNext(){
        this.next=this.next.next;
    }

    public void after(LoopNode node){
        node.next=this.next;
        this.next=node;

    }



    public LoopNode next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

}
