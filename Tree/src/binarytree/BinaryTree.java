package binarytree;

import java.util.Stack;

public class BinaryTree {

    /**
     * 二叉树:任一个节点的子节点数量不超过2
     *
     * 满二叉树:所有叶子节点都在最后一层,而且节点的总数是:2^n-1,n是树的高度
     *
     * 完全二叉树:所有叶子节点都在最后一层或倒数第二层,而且最后一层的叶子节点在左边连续,倒数第二节的叶子节点在右边连续(能够数满)
     */

    /**
     * 链式存储二叉树
     */
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void frontShow() {
        if (root != null)
            root.frontShow();
    }

    public void midShow() {
        if (root != null)

            root.midShow();
    }

    public void afterShow() {
        if (root != null)
            root.afterShow();
    }

    public TreeNode frontSelect(int i) {
        return root.frontSelect(i);
    }

    public TreeNode midSelect(int i) {
        return root.midSelect(i);
    }

    public TreeNode afterSelect(int i) {
        return root.afterSelect(i);
    }

    public void delete(int i) {
        if (root.value == i)
            root = null;
        else {
            root.delete(i);
        }
    }

    public void posOrder1()
    {
        TreeNode Node=root;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(Node != null || !stack1.empty())
        {
            while (Node != null)
            {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.leftNode;
            }

            while(!stack1.empty() && stack2.peek() == i)
            {
                stack2.pop();
                System.out.print(stack1.pop().value + "   ");
            }

            if(!stack1.empty())
            {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.rightNode;
            }
        }
    }



}
