package binarytree.binarysorttree;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr=new int[]{7,3,10,12,5,1,9};
        //创建一颗二叉排序树
        BinarySortTree bst=new BinarySortTree();
        //循环添加
        for(int i :arr){
            bst.add(new Node(i));
        }
        //遍历的值从小到大排列
        bst.midShow();

        //查找
        Node node=bst.search(32);
        System.out.println(node);

        //测试查找父节点
//        System.out.println();
//        Node searchParent=bst.searchParent(1);
//        System.out.println(searchParent.value);

        //删除叶子节点
//        System.out.println();
//        bst.delete(5);
//        bst.midShow();

        //删除只有一个叶子节点子树
//        System.out.println();
//        bst.delete(3);
//        bst.midShow();


        System.out.println();
        bst.delete(7);
        bst.midShow();

    }
}
