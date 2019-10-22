package com.insert;

import java.util.Arrays;

/**
 * 思想:
 * 把n个带排序的元素看成为一个有序表和一个无序表,开始时有序表中只包含一个元素,
 * 无序表中包含有n-1个元素,排序过程中每次从无序表中取出第一个元素,
 * 把它的排序码依次与有序表元素的排序码进行比较,将它插入到有序表中的适当位置,
 * 使之成为新的有序表
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[]=new int[]{66,56,47,89,5,8,4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){

            //现将无序表中的第一个数保存起来
            int insertVal=arr[i];
            int insertIndex=i-1;  //表示有序表的最后这个元素的下标

            //还没找到位置
            //1.insertIndex>=0保证在给insertVal找插入位置,不越界
            //2.insertVal<arr[insertIndex]待插入的数,还没有找到插入位置
            //3.就需要将arr[insertIndex]后移
            while(insertIndex>=0&&insertVal<arr[insertIndex]){
                //如果没找到,就将insertIndex覆盖到后面那个数
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex-=1;
            }
            //退出while,说明插入的位置找到了
            arr[insertIndex+1]=insertVal;
        }
    }
}
