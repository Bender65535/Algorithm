package binarytree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binTree=new BinaryTree();

        TreeNode root=new TreeNode(1);
        binTree.setRoot(root);

        TreeNode rootL=new TreeNode(2);
        root.setleftNode(rootL);

        TreeNode rootR=new TreeNode(3);
        root.setrightNode(rootR);
    }
}
