package threaded;

public class ThreadedBinaryTree {

    /**
     * 线索二叉树
     *
     * 二叉树的节点的空链域的个数总是多过非空链域的个数, 因此，提出了一种方法，利用原来的空链域存放指针，指向树中其他结点
     *
     * 线索化二叉树时,一个节点的前一个节点,叫前驱节点
     * 线索化二叉树时,一个节点的后一个节点,叫后继节点
     */
    ThreadedNode root;

    //用于临时存储前驱节点
    ThreadedNode pre=null;


    //遍历线索二叉树
    public void threadIterate(){
        ThreadedNode node=root;
        while(node!=null){
            //循环找到最开始的节点
            while (node.leftType==0){
                node=node.leftNode;
            }
            //打印当前节点的值
            System.out.println(node.value);

            //如果当前节点的右指针指向的是后继节点,可能后继节点还有后继节点
            while(node.rightType==1){
                node=node.rightNode;
                System.out.println(node.value);
            }

            //替换遍历的节点
            node=node.rightNode;
        }
    }

    //中序线索化二叉树
    public void threadNodes(){
        threadNodes(root);
    }
    public void threadNodes(ThreadedNode node){
        //当前节点如果为null,直接返回
        if(node==null)
            return;

        //处理左子树
        threadNodes(node.leftNode);


        //处理前驱节点
        if(node.leftNode==null){
            //让单前节点的左指针指向前驱节点
            node.leftNode=pre;
            //改变当前左指针的类型
            node.leftType=1;
        }

        //处理前驱的右指针,如果前驱节点的右指针是null(没有指向右子树)
        if(pre!=null&&pre.rightNode==null){
            //让前驱节点的右指针指向当前节点
            pre.rightNode=node;
            //改变前驱节点的右指针类型
            pre.rightType=1;
        }

        //每处理一个节点,当前节点是下一个节点的前驱节点(上一个节点与下一个节点是中序遍历的顺序)
        pre=node;


        //处理右子树
        threadNodes(node.rightNode);
    }




    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public ThreadedNode getRoot() {
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







}
