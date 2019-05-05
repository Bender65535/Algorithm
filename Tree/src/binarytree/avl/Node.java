package binarytree.avl;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null)
            return 0;
        else
            return left.height();
    }

    /**
     * 返回右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null)
            return 0;
        else
            return right.height();
    }


    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加节点的值比当前节点的值更小
        if (node.value < this.value) {
            //如果左节点为空
            if (this.left == null) {
                this.left = node;
                //如果不为空
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //查询是否平衡
        //进行右旋
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            if(left!=null&&left.leftHeight()<left.rightHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                //单旋转
                rightRotate();
            }
        }

        //左旋转
        if (leftHeight() - rightHeight() <= -2) {
            if(right!=null&&right.leftHeight()<left.rightHeight()){
                //双旋转
                right.rightRotate();
                leftRotate();
            }else {
                //单旋转
                leftRotate();
            }
        }
    }

    /**
     * 左旋转
     */
    private void leftRotate() {

        Node newLeft = new Node(value);

        newLeft.left = left;

        newLeft.right = right.left;

        value = right.value;

        right = right.right;

        left = newLeft;
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        /**
         * 1.创建与当前节点一样的节点
         * 2.把新节点的右子树设置为当前节点的右子树
         * 3.把新节点的左子树设置为当前节点的左子树的右子树
         * 4.把当前节点的值换为左子节点的值
         * 5.把当前节点的左子树设置为左子树的左子树
         * 6.把当前节点的右子树设置为右节点
         */
        //1.创建与当前节点一样的节点
        Node newRight = new Node(value);
        //2.把新节点的右子树设置为当前节点的右子树
        newRight.right = right;
        //3.把新节点的左子树设置为当前节点的左子树的右子树
        newRight.left = left.right;
        //4.把当前节点的值换为左子节点的值
        value = left.value;
        //5.把当前节点的左子树设置为左子树的左子树
        left = left.left;
        //6.把当前节点的右子树设置为右节点
        right = newRight;
    }

    public void midShow() {
        if (this.left != null) {
            this.left.midShow();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.midShow();
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }

    /**
     * 搜索父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        //找到父节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;

            //没找到,往下查找
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            }
            //都没找到
            return null;
        }
    }

}
