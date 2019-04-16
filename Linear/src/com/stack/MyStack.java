package com.stack;

public class MyStack {
    private int[] elements;

    public MyStack(){
        elements=new int[0];
    }
    public void show(){
        for(int i=0;i<elements.length;i++)
            System.out.print(elements[i]+" ");
    }

    public void push(int element){
        int[] newElements=new int[elements.length+1];
        for(int i=0;i<elements.length;i++){
            newElements[i]=elements[i];
        }
        newElements[newElements.length-1]=element;
        elements=newElements;
    }

    public int pop(){
        if(elements.length==0)
            throw new RuntimeException("stack is empty");
        int element=elements[elements.length-1];
        int newArr[]=new int[elements.length-1];
        for(int i=0;i<elements.length-1;i++){
            newArr[i]=elements[i];
        }
        elements=newArr;
        return element;
    }
}
