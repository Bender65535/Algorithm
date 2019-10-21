package threaded;

public class ThreadedNode {
    //    权
    int value;

    //    左节点
    ThreadedNode leftNode;
    //    右节点
    ThreadedNode rightNode;

    //标识指针类型
    int leftType;
    int rightType;

    public ThreadedNode(int value) {
        this.value = value;
    }

    public void setleftNode(ThreadedNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setrightNode(ThreadedNode rightNode) {
        this.rightNode = rightNode;
    }

    public void frontShow() {
        //先遍历当前节点的内容
        System.out.println(value);
        //左节点
        if (leftNode != null)
            leftNode.frontShow();
        //右节点
        if (rightNode != null)
            rightNode.frontShow();
    }

    public void midShow() {
        if(leftNode!=null)
            leftNode.midShow();
        System.out.println(value);
        if(rightNode!=null)
            rightNode.midShow();
    }

    public void afterShow() {
        if(leftNode!=null)
            leftNode.afterShow();
        if (rightNode!=null)
            rightNode.afterShow();
        System.out.println(value);
    }





}
