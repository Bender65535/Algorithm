package com.arraylist;

public class ObjectArray {
    private int[] array;
    public ObjectArray(){
        array=new int[0];
    }

    public void show(){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }

    public int size(){
        return array.length;
    }

    public int[] add(int element){
        int[] newarray=new int[array.length+1];
        for (int i=0;i<array.length;i++){
            newarray[i]=array[i];
        }
        newarray[array.length]=element;
        array=newarray;
        return array;
    }

    public int[] delete(int index){
        if(index<0||index>array.length-1)
            throw new RuntimeException("下标越界");


        int[] newarray=new int[array.length-1];
        for(int i=0;i<array.length;i++){
            if(i<index){
                newarray[i]=array[i];
            }
            else if(i>index){
                newarray[i-1]=array[i];
            }
        }
        array=newarray;
        return array;
    }
    public int[] insert(int index,int num){
        if(index<0||index>array.length-1)
            throw new RuntimeException("下标越界");
        int[] newarray=new int[array.length+1];
        for(int i=0;i<array.length+1;i++){
            if (i<index)
                newarray[i]=array[i];
            else if (i==index)
                newarray[i]=num;
            else
                newarray[i]=array[i-1];
        }
        array=newarray;
        return array;
    }
}
