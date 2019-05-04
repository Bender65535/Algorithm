package binarytree;

/**
 * 顺序存储的二叉树只考虑完全二叉树
 * 第n个元素的左子节点是:2*n+1(n从0开始)
 * 第n个元素的右子节点是:2*n+2(n从0开始)
 * 第n个元素的父节点是:(n-1)/2
 */

public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data){
        this.data=data;
    }

    public void frontShow(){
        frontShow(0);
    }
    //前序遍历
    public void frontShow(int index){
        if(data==null||data.length==0)
            return;

        //先遍历当前节点的内容
        System.out.println(data[index]);
        //遍历左节点(2*index+1)
        if(2*index+1<data.length){
            //如果左节点的下标在范围内(即存在)
            frontShow(2*index+1);
        }
        //遍历右子树(2*index+2)
        if(2*index+2<data.length)
            frontShow(2*index+2);
    }
}
