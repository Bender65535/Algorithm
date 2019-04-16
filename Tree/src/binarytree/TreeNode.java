package binarytree;

public class TreeNode {
//    权
    int value;

//    左节点
    TreeNode leftNode;
//    右节点
    TreeNode rightNode;

    public TreeNode(int value){
        this.value=value;
    }

    public void setleftNode(TreeNode leftNode){
        this.leftNode=leftNode;
    }
    public void setrightNode(TreeNode rightNode){
        this.rightNode=rightNode;
    }
}
