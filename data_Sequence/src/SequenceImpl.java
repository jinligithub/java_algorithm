public class SequenceImpl implements Sequence{

    //虚拟头结点，不存储元素，专门作为头结点使用
    private Node dummyHead;
    private int size;

    public SequenceImpl() {
        this.dummyHead=new Node(null,null);
    }

    private class Node{
        Object data;
        Node next;
        public Node(Object data,Node next) {
            this.data = data;
            this.next=next;
        }
        public Node(Object data) {
            this.data = data;
        }
    }
    @Override
    public void add(Object data) {
        //尾插
        addLast(data);
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        //获取到前驱节点
        Node cur=node(index);
        prev.next=cur.next;
        //清空当前节点
        cur.next=cur=null;
        size--;
        return true;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        //取得相应的index的Node节点
        Node node=node(index);
        Object oldData=node.data;
        node.data=newData;
        return oldData;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        //取得相应index的Node节点
        Node node=node(index);
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
        //取得链表中的节点中的数据
        Object[] datas=toArray();
        //如果要查找的data为null
        if(data==null){
            for(int i=0;i<datas.length;i++){
                if(datas[i]==null){
                    return true;
                }
            }
        }else{
            for(int i=0;i<datas.length;i++){
                if(data.equals(datas[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        //遍历节点将数据储存到对象数组中
        Object[] datas=new Object[size];
        int i=0;
        for(Node temp=dummyHead.next;temp!=null;temp=temp.next){
            datas[i++]=temp.data;
        }
        return datas;
    }
//链表的清空
    @Override
    public void clear() {
        for(Node temp=dummyHead.next;temp!=null;temp=temp.next){
            temp.data=null;
            Node node=temp.next;
            temp.next=null;
            size--;
        }

    }
    //在任意位置插入数据
    public void add(int index ,Object data){
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node newNode=new Node(data);
        newNode.next=prev.next;
        prev.next=newNode;
        size++;
    }

    //
    private void addFrist(Object data){
        add(0,data);
    }

    private void addLast(Object data){
        add(size,data);
    }

    //判断index是否合法
    private  void rangeCheck(int index){
        if(index<0||size<index){
            throw  new IndexOutOfBoundsException("Illegal index");
        }
    }

    //取得index的当前节点
    private Node node(int index){
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return  cur;
    }
}
