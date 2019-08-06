public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree=new BinaryTree();
        //创建节点
        Node  root=new Node(0,"zh");
        Node  node1=new Node(1,"zhangsan");
        Node  node2=new Node(2,"zhang");
        Node  node3=new Node(3,"san");
        Node  node4=new Node(4,"zhangsan2");

        //手动 加入关系
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node1.setRight(node4);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("Zhong序遍历");
        binaryTree.midOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();



    }
}

//创建节点
class Node{
     private int no;
     private String name;
     private Node left;//默认null
     private Node right;//默认null

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void  preOrder(){
        System.out.println(this);//先输出当前节点
        //递归左子树进行前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归右子树进行前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }


    //中序遍历
    public  void midOrder(){
        //递归向左子树进行遍历
        if(this.left!=null){
            this.left.midOrder();
        }
        //输出节点
        System.out.println(this);

        //递归向右子树进行中序遍历
        if(this.right!=null){
            this.right.midOrder();
        }
    }

    //后序遍历

    public void postOrder(){
        //递归左子树进行后续遍历
        if(this.left!=null){
            this.left.postOrder();
        }
        //递归右子树进行后续遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        //输出节点
        System.out.println(this);
    }
}

//穿件一个二叉树
class BinaryTree{
    private Node root;//根节点

    public void setRoot(Node root){
        this.root=root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("BIanryTree is empty");
        }

    }

    //前序遍历
    public void midOrder(){
        if(this.root!=null){
            this.root.midOrder();
        }else {
            System.out.println("BIanryTree is empty");
        }

    }

    //前序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("BIanryTree is empty");
        }

    }



}