package com.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{54,43,5,2,4,82,234,61,52,4,53};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int low,int high){
        int middle=(low+high)/2;
        if(low<high){
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }

    public static void merge(int arr[],int low,int middle,int high){
//        用于存储归并后的临时数组
        int[] tem=new int[high-low+1];
        int index=0;

//        记录第一个数组中需要遍历的下标
        int i= low;
//        记录第二个数组中需要遍历的下标
        int j=middle+1;


//        遍历两个数组,取出小的数字放入临时数组中
        while(i<=middle && j<=high){
            if(arr[i]<arr[j]){
                tem[index]=arr[i];
                i++;
            }
            else{
                tem[index]=arr[j];
                j++;
            }

            index++;
        }

//        处理剩下的数组
        while (i<=middle){
            tem[index]=arr[i];
            i++;
            index++;
        }
        while (j<=high){
            tem[index]=arr[j];
            j++;
            index++;
        }

        for(int k=0;k<tem.length;k++){
            arr[k+low]=tem[k];
        }
    }
}
