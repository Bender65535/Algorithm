package binarytree;

public class TreeNode {
    //    权
    int value;

    //    左节点
    TreeNode leftNode;
    //    右节点
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
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

    public TreeNode frontSelect(int i) {
        TreeNode target=null;
        if(this.value==i){
            return this;
        }
        else {
            if(leftNode!=null) {
                target=leftNode.frontSelect(i);
            }
            if(target!=null)
                return target;


            if(rightNode!=null) {
                target=rightNode.frontSelect(i);
            }
            return target;
        }
    }

    public TreeNode midSelect(int i) {
        TreeNode target=null;
        if(leftNode!=null)
            target=leftNode.midSelect(i);
        if(target!=null)
            return target;

        if(this.value==i)
            return this;

        if(rightNode!=null)
            target=rightNode.midSelect(i);
        return target;
    }

    public TreeNode afterSelect(int i) {
        TreeNode target=null;
        if(leftNode!=null)
            target=leftNode.afterSelect(i);
        if(target!=null)
            return target;

        if(rightNode!=null)
            target=rightNode.afterSelect(i);

        if(this.value==i)
            return this;

        return target;
    }

    //删除一个节点(或子树)
    public void delete(int i) {
        TreeNode parent=this;
        //查看下一层有没有要删除的节点
        if(leftNode!=null&&parent.leftNode.value==i){
            parent.leftNode=null;
            return;
        }
        if(rightNode!=null&&parent.rightNode.value==i){
            parent.rightNode=null;
            return;
        }

        //如果没找到
        //递归删除左儿子
        parent=leftNode;
        if(parent!=null)
            parent.delete(i);

        //递归删除右儿子
        parent=rightNode;
        if(parent!=null)
            parent.delete(i);

    }



}
