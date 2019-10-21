package com.exchange;

/**
 * 基本思想:
 * 通过对待排序序列从前向后(从下标较小的元素开始),
 * 依次比较相邻元素的值,若发现逆序则交换,使值较大的元素逐渐从前向后部,
 * 就像水底的气泡一样逐渐向上冒
 */
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
