package com.select;

import java.util.Arrays;

/**
 * ,基本思想:
 * 第一次从arr[0]~arr[n-1]中选取最小值,与arr[0]交换,
 * 第二次从arr[1]~arr[n-1]中选取最小值,与arr[1]交换,
 * ...
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值,与arr[n-2]交换
 * 总共通过n-1次,得到一个从小到大排列的有序序列
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{45,3,26,25,7,61,43};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){

            //j和i比,如果比i小就交换,第一次遍历i为最小值
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
