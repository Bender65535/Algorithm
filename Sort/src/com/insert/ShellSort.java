package com.insert;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr=new int[]{3,52,6,42,3,7,2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int N=arr.length;
        int h=1;
        while (N/3>h)
            h=h*3+1;
        while (h>0){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h;j-=h){
                    int tem;
                    if(arr[j]<arr[j-h]){
                        tem=arr[j];
                        arr[j]=arr[j-h];
                        arr[j-h]=tem;
                    }
                }
            }
            h=h/3;
        }
    }
}
