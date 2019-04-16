package com.select;

import java.util.Arrays;

/**
 * 直接找最小
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{45,3,26,25,7,61,43};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length-1;j++){
                if(arr[i]>arr[j+1]){
                    int tem=arr[i];
                    arr[i]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
        }
    }
}
