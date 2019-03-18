
public class LinkedList {
    //火车头结点
    private Node head;
    //链表的大小
    private int size;
    public LinkedList(){
        head=null;
        size=0;
    }
    //每个节点类
    private class Node{
        Object data;
        Node next;
        public Node(Object data,Node node) {
            this.data = data;
            this.next=next;
        }
        public Node(Object data ){
            this.data=data;
        }
    }
    //将节点头插进入火车
    public void addFrist(Object data){
        //创建新的节点
//        Node newNode=new Node(data);
//        //将当前节点指向原来的火车头结点
//        newNode.next=head;
//        head=newNode;
        head=new Node(data,head);
        size++;
    }
    //在任意位置插入数据
    public void add(int index,Object data){
        //当插入的位置小于0，或者大于链表的长度.  抛出异常
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("inde illegal");
        }
        //当要插入的位置是 头结点
        if(index==0){
            addFrist(data);
        }else {
            //找到index的前驱节点
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//        Node newNode=new Node(data);
//        newNode.next=prev.next;
//        prev.next=newNode;
            prev.next = new Node(data, prev.next);
            size++;
        }
    }
    public void addLast(Object data){
        add(size,data);
    }
}
