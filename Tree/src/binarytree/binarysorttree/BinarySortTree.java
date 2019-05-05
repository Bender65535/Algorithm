package binarytree.binarysorttree;

/**
 * 二叉排序树(二叉搜索树BST)
 * 对于二叉树中的任意一个非叶子节点,要求左节点比当前节点值小,右子节点比当前节点值大
 *
 *
 * 顺序存储,不排序:查找困难
 * 顺序存储,排序:删除困难
 * 链式存储:无论是否排序,查找困难
 */
public class BinarySortTree {
    Node root;

    /**
     * 向二叉排序树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


    /**
     * 中序遍历二叉排序树
     */
    public void midShow() {
        if (root != null) {
            root.midShow();
        }
    }

    /**
     * 节点的查找
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 删除节点
     */
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //找到这个节点
            Node target = search(value);
            //如果没有这个节点
            if (target == null) {
                return;
            }
            //找到父节点
            Node parent = searchParent(value);

            //1.要删除的是叶子节点
            if (target.left == null && target.right == null) {
                //1.1删除的是父节点的左子节点
                if (parent.left.value == value) {
                    parent.left = null;

                    //1.2删除的是父节点的右子节点
                } else {
                    parent.right = null;
                }


                //2.要删除的是非叶子节点(子树)
                //2.1有两个叶子节点
            } else if (target.left != null && target.right != null) {
                //2.1.1删除右子树中值最小的节点,并获取到该节点的值
                //传入右子树
                int min =deleteMin(target.right);
                //替换目标节点中的内容
                target.value=min;


                //2.2要删除的节点只有一个左子节点或右子节点
            } else {
                //有左子节点
                if (target.left != null) {
                    //删除的是父节点的左子节点
                    if (parent.left.value == value) {
                        parent.left = target.left;
                        //删除的是父节点的右子节点
                    }else {
                        parent.right = target.left;
                    }

                    //有右子节点
                } else {
                    //删除的是父节点的左子节点
                    if (parent.left.value == value) {
                        parent.left = target.right;
                        //删除的是父节点的右子节点
                    }else {
                        parent.right = target.right;
                    }
                }

            }

        }
    }

    /**
     * 删除一颗树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target=node;
        //递归找出最左节点
        while(target.left!=null){
            target=target.left;
        }
        //如果这个节点有子节点
//        if(target.right!=null){
//
//        }else {
//
//        }
        //删除最小的节点
        delete(target.value);
        return target.value;
//        return 0;
    }

    /**
     * 搜索父节点
     *
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


}
