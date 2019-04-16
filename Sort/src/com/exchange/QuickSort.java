package com.exchange;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 * 缺点:2,3,4,5,6,1
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,8,7,1,9,5,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

//    此方法需要递归
    public static void quickSort(int[] arr,int start,int end){

        if(start<end){


            int low=start;
            int high=end;
//数组中的第0个数为标准数
            int stand=arr[start];
//记录需要排序的下标


            //循环找比标准数大的数和比标准数小的数
            while(low<high){
//            如果右边的数大于标准数,则end左移
                while(low<high && stand<=arr[high])
                    high--;
//            如果右边的数小于标准数,则把右边的数覆盖到左边
                arr[low]=arr[high];

                while(low<high && stand>=arr[low])
                    low++;

                arr[high]=arr[low];
            }
//        当指针重合时,把标准数赋给指针
            arr[high]=stand;

//            递归标准数左边的数组
            quickSort(arr,start,high);
//            递归标准数右边的数组
            quickSort(arr,high+1,end);
        }




    }

}
