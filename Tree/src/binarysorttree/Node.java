package binarysorttree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(Node node) {
        if(node==null){
            return;
        }

        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加节点的值比当前节点的值更小
        if(node.value<this.value){
            //如果左节点为空
            if(this.left==null){
                this.left=node;
                //如果不为空
            }else{
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void midShow() {
        if(this.left!=null){
            this.left.midShow();
        }
        System.out.println(this.value);
        if(this.right!=null){
            this.right.midShow();
        }
    }

    public Node search(int value) {
        if(this.value==value){
            return this;
        }else if(value<this.value){
            if(left==null){
                return null;
            }
            return left.search(value);
        }else{
            if(right==null){
                return null;
            }
            return right.search(value);
        }
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        //找到父节点
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;

            //没找到,往下查找
        }else {
            if(this.value>value&&this.left!=null){
                return this.left.searchParent(value);
            }
            else if(this.value<value&&this.right!=null){
                return this.right.searchParent(value);
            }
            //都没找到
            return null;
        }
    }

}
