package com.bite.Josepfu;

public class Josepfu {
    public static void main(String[] args) {
        //构建环形链表
        CricleSingleList cricleSingleList=new CricleSingleList();
        cricleSingleList.add(5);
        cricleSingleList.show();
        cricleSingleList.countNode(1,2,5);
    }
}

//创建单向的环形链表
class CricleSingleList{
    //创建head节点
    private Node head=new Node(-1);
    //添加一个尾节点，构成一个环形链表
    public void add(int nums){
        //判断num是否合法
        if(nums<1){
            System.out.println("num的值不正确");
            return;
        }
        //创建辅助节点
        Node temp=null;
        for(int i=1;i<=nums;i++){
            //根据编号创建节点
            Node node=new Node(i);
            //如果是第一个节点
            if(i==1){
                head=node;
                head.setNext(node);//成环
                temp=node;//temp执行第一个节点
            }else {
                temp.setNext(node);//大年节点的下一个节点指向新节点
                node.setNext(head);//下一个节点指向头结点，成环
                temp=node;//temp指向新的节点
            }


        }

    }
    //遍历环形链表’
    public void show(){
        //判断链表是否为null
        if(head==null){
            System.out.println("没有节点");
            return;
        }
        //因为头节点没法动，所以无法使用辅助指针完成遍历
        Node cur=head;
        while(true){
            System.out.println("节点的编号: "+cur.getNum());
            if(cur.getNext()==head){
                //说明遍历结束
                break;
            }
            cur=cur.getNext();//当前接地那个先后移动
        }
    }
    /*
    startNo：表示从第几个节点开始数数
    count：表示数几下
    nums: 表示最初有几个节点
     */

    public  void countNode(int startNo,int count,int nums){
        //判断链表是否为null,或者参数是否有误
        if(head==null||startNo<1||startNo>nums){
            System.out.println("输入有误");
            return;
        }
        //创建临时变量，帮助出圈
        Node temp=head;
        //让temp指向环形链表的最后一个节点
        while(true){
            if(temp.getNext()==head){//说明temp 的下一个节点是头结点
                break;
            }
            temp=temp.getNext();
        }

        //当报数时，让head节点和temp节点同时移动k-1次，因为从第K个节点开始遍历
        for(int i=0;i<startNo-1;i++){
            head=head.getNext();
            temp=temp.getNext();
        }
        //当报数时，让head节点和temp节点同时移动m-1次，然后出圈
        //出圈。直到还有一个节点
        while(true){
            if(temp==head){//说明圈里只有一个人
                break;
            }
            //让head和temp同时移动count-1次
            for(int j=0;j<count-1;j++ ){
                head=head.getNext();
                temp=temp.getNext();
            }
            //这是head指向的节点就是要出圈的节点
            System.out.println("出圈节点： "+head.getNum());
            //这时将节点出圈
            head=head.getNext();
            temp.setNext(head);
        }
        System.out.println("最后的节点："+head.getNum());

    }

}



//创建Node类，表示一个节点
class Node{
    private int num;
    private Node next;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int num){
        this.num=num;
    }


}