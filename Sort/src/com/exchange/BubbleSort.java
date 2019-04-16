package com.exchange;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{15,3,1,5,864,4,486,65,8};
        int tem;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
        }


        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
