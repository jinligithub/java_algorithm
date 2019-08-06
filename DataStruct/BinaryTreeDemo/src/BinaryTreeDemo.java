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

        System.out.println("qianxu ");
        Node re=binaryTree.preOrderSearch(3);
        if(re!=null){
            System.out.printf("找到了 no=%d  name =%s",re.getNo(),re.getName());
        }else {
            System.out.println("没有找到");
        }




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


    //前序查找
    public Node preOrderSearch(int no){
        //比较当节点是否为要查找的节点: 是就直接返回
        if(this.no==no){
            return this;
        }
        //1.判断当前节点的左子节点是否为null,不为空递归前序查找
        //2.如果左递归查找，找到该节点就返回
        Node resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode!=null){//说明 左子树找到了
            return resNode;
        }
        //3.。没有找到，就判断当前接地点的右子树节点是否为null，如果不是就子昂有进行前序查找
        if(this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public  Node midOrderSearch(int no){
         //判断当前节点的左子树是否为null
        Node resNode=null;
        if(this.left!=null){
            resNode=this.left.midOrderSearch(no);
        }
        //如果找到了就返回，
        if(resNode!=null){
            return resNode;
        }
        //左子树没有找到就和当前节点进行比较，是当前节点就返回
        if(this.no==no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if(this.right!=null){
            resNode=this.right.midOrderSearch(no);
        }
        return resNode;
    }
    //后续查找
    public Node postOrderSearch(int no){
        //判断当前节点的左子节点是否为null,如果不为null，则进行有序查找
         Node resNode=null;
         if(this.left!=null){
             resNode=this.left.postOrderSearch(no);
         }
         if(resNode!=null) {//说明找到了
             return resNode;
         }
         //如果左子树没有找到，则向右子树进行前序中昂徐后续的遍历查找
        if(this.right!=null){
            resNode =this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //如果左右子树都没有找到，就比较当前节点是不是要查找的节点
        if(this.no==no){
            return this;
        }
        return resNode;

    }

}

//创建一个二叉树
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

    //前序查找
    public Node preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        }else {
            System.out.println("BinaryTree is empty");
            return null;
        }
    }  //中序查找
    public Node midOrderSearch(int no){
        if(root!=null){
            return root.midOrderSearch(no);
        }else {
            System.out.println("BinaryTree is empty");
            return null;
        }
    }  //后序查找
    public Node postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        }else {
            System.out.println("BinaryTree is empty");
            return null;
        }
    }



}