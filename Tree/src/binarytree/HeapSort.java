package binarytree;

import java.util.Arrays;

/**
 * 堆
 * 大顶堆:父节点的值大于任何的子节点(升序排序使用大体堆)
 * 小顶堆:父节点的值小于任何的子节点(升序排序使用大体堆)
 *
 * 将最后一个非叶子节点与其叶子节点进行比较,如果比叶子节点小,交换位置
 * 之后再对前一个非叶子节点进行操作
 * 交换之后还要再和叶子节点进行比较,满足条件就交换
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{9,6,8,7,0,1,10,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //开始位置是最后一个非叶子节点(每个节点的父节点为单前节点所对应的的(数组下标-1)/2)
        int start=(arr.length-1)/2;
        //调整为大顶堆
        for(int i=start;i>=0;i--){
            maxHeap(arr,arr.length,i);
        }
        //先把数组中的第0个和堆中的最后一个数交换,再把前面的处理为大顶堆
        for(int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeap(arr,i,0);
        }
    }

    //大顶堆
    public static void maxHeap(int[] arr,int size,int index){
        //左子节点
        int leftNode=2*index+1;
        //右子节点
        int rightNode=2*index+2;

        //和两个子节点分别对比,找出最大的节点
        int max=index;
        if(leftNode<size&&arr[leftNode]>arr[max]){
            max=leftNode;
        }
        if(rightNode<size&&arr[rightNode]>arr[max]){
            max=rightNode;
        }

        //找到最大节点后交换位置
        if(max!=index){
            int temp=arr[index];
            arr[index]=arr[max];
            arr[max]=temp;

            //交换位置后,可能会破坏之前排好的堆,所以,之前排好的堆需要重新调整
            maxHeap(arr,size,max);
        }
    }
}
