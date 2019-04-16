package com.arraylist;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        int target=3;
        int begin =0;
        int end=arr.length-1;
        int mid=(begin+end)/2;
        int index=-1;
        while(true){
            if(target!=arr[mid]){
                if(target<arr[mid]){
                    end=mid-1;
                }
                else if(target>arr[mid]) {
                    begin=mid+1;
                }
                mid=(begin+end)/2;

            }
            else{
                index=mid;
                break;
            }
            if(begin==end)
                break;
        }
        System.out.println(index);
    }
}
