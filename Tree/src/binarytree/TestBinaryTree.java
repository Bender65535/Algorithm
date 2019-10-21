package binarytree;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一颗树
        BinaryTree binTree=new BinaryTree();
        //创建根节点
        TreeNode root=new TreeNode(1);
        //把根节点赋给树
        binTree.setRoot(root);

        TreeNode rootL=new TreeNode(2);
        root.setLeftNode(rootL);

        TreeNode rootR=new TreeNode(3);
        root.setRightNode(rootR);

        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        //前序遍历
//        binTree.frontShow();

        //中序遍历
//        binTree.midShow();

        //后序遍历
//        binTree.afterShow();

        //前序查找
//        TreeNode result=binTree.frontSelect(3);
//        System.out.println(result);

        //中序查找
//        TreeNode result=binTree.midSelect(3);
//        System.out.println(result);

        //后序遍历
//        TreeNode result = binTree.afterSelect(98);
//        System.out.println(result);

        //删除一个节点(或是子树)
//        binTree.delete(3);
//        binTree.frontShow();

        //非递归后序遍历
        binTree.posOrder1();
    }
}
