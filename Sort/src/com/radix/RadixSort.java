package com.radix;

import java.util.Arrays;

/**
 * 基数排序
 * 通过键值的各个位的值,将要排序的元素分配至某些桶中
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[]=new int[]{5,31,543,234,12,643,93,834,83,2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        int maxLenth=(max+"").length();

        //临时数组
        int[][] temp=new int[10][arr.length];

        //记录每位数的个数
        int[] count=new int[10];


        for(int i=0,N=1;i<maxLenth;i++,N*=10){

            //存入数字
            for(int j=0;j<arr.length;j++){
                int rest=arr[j]/N%10;
                temp[rest][count[rest]]=arr[j];
                count[rest]++;
            }


            //用来记录取出的个数
            int take=0;

            //取出数字
            for(int j=0;j<10;j++){
                for(int k=0;k<count[j];k++){
                    arr[take]=temp[j][k];
                    take++;
                }
            }
            count=new int[10];
            temp=new int[10][arr.length];

        }

    }
}
