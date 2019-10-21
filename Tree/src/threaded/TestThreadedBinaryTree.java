package threaded;

public class TestThreadedBinaryTree {
    public static void main(String[] args) {

        //创建一颗树
        ThreadedBinaryTree binTree=new ThreadedBinaryTree();
        //创建根节点
        ThreadedNode root=new ThreadedNode(1);
        //把根节点赋给树
        binTree.setRoot(root);

        ThreadedNode rootL=new ThreadedNode(2);
        root.setleftNode(rootL);

        ThreadedNode rootR=new ThreadedNode(3);
        root.setrightNode(rootR);

        rootL.setleftNode(new ThreadedNode(4));
//        ThreadedNode fiveNode=new ThreadedNode(5);
//        rootL.setRightNode(fiveNode);

        rootR.setleftNode(new ThreadedNode(6));
        rootR.setrightNode(new ThreadedNode(7));

        //中序遍历树
        binTree.midShow();
        System.out.println();
        //中序线索化二叉树
//        binTree.threadNodes();
        //获取5节点的后继节点
//        ThreadedNode rightNode=fiveNode.rightNode;
//        System.out.println(rightNode.value);

        System.out.println("==================");
        //中序线索化二叉树
        binTree.threadNodes();
        binTree.threadIterate();
    }
}
