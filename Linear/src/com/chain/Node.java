package com.chain;

public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data=data;
    }

    //追加节点
    public Node append(Node node){
        Node currentNode=this;
        while (true){
            if(currentNode.next!=null)
                currentNode=currentNode.next;
            else {
                currentNode.next=node;
                break;
            }
        }
        return this;
    }

    public void removeNext(){
        this.next=this.next.next;
    }

    public void after(Node node){
        node.next=this.next;
        this.next=node;

    }


    public void show(){
        Node current=this;
        while (current!=null){
            System.out.println(current.getData());
            current=current.next;
        }
    }

    public Node next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public boolean isLast(){
        return this.next==null;
    }
}
