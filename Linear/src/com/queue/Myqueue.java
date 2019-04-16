package com.queue;

public class Myqueue {
    private int[] queue;
    public Myqueue(){
        queue=new int[0];
    }

    public void show(){
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i]+" ");
    }

    public  void add(int element){
        int[] newqueue =new int[queue.length+1];
        for(int i=0;i<queue.length;i++)
            newqueue[i]=queue[i];
        newqueue[queue.length]=element;
        queue=newqueue;
    }

    public void poll(){
        int[] newqueue=new int[queue.length-1];
        for(int i=0;i<newqueue.length;i++)
            newqueue[i]=queue[i+1];
        queue=newqueue;
    }
}
