package com.insert;

import java.util.Arrays;

/**
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[]=new int[]{66,56,47,89,5,8,4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        int tem;
        for(int i=1;i<arr.length;i++){


//            int j=i;
//            0开始的数组,从第1个开始排,对比之前的数字
//            while (j>=1 && arr[j-1]>arr[j]){
//                tem=arr[j-1];
//                arr[j-1]=arr[j];
//                arr[j]=tem;
//                j--;
//            }


            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    tem=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tem;
                }
                else
                    break;
            }
        }
    }
}
