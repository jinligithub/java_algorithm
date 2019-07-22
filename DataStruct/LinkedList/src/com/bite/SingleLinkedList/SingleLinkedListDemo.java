package com.bite.SingleLinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        Node node1 = new Node(1, "zhangsan", "张三");
        Node node2 = new Node(2, "zhangsan", "张三");
        Node node3 = new Node(3, "lisi", "张三");
        Node node4 = new Node(4, "zhangsan", "张三");
        //创建单链表
        SingledLinkedList singledLinkedList = new SingledLinkedList();

        //添加节点
//        singledLinkedList.add(node1);
//        singledLinkedList.add(node2);
//        singledLinkedList.add(node3);
//        singledLinkedList.add(node4);
//        singledLinkedList.list();

        singledLinkedList.addByOrder(node1);
        singledLinkedList.addByOrder(node4);
        singledLinkedList.addByOrder(node3);
        singledLinkedList.addByOrder(node2);
        singledLinkedList.list();
        //System.out.println(singledLinkedList.getLength(singledLinkedList.getHead()));
        //  System.out.println(singledLinkedList.findLastIndexNode(singledLinkedList.getHead(),2));

//        Node node5=new Node(3,"wangwu","wangwu");
//        singledLinkedList.updata(node5);
//
//        singledLinkedList.list();
//        singledLinkedList.remove(2);
//        singledLinkedList.list();
//
        singledLinkedList.reverse(singledLinkedList.getHead());
        singledLinkedList.list();
        System.out.println();
        singledLinkedList.reversePrint(singledLinkedList.getHead());
    }
}

//定义SingleLinkedList
class SingledLinkedList {
    //先初始化一个头结点，头节点不能动，不放数据，只是为了能找到链表
    private Node head = new Node(0, "", "");

    /*

    添加数据到单链表

    思路：当不考虑编号顺序的时候
    1.找到当前链表的最后节点
    2.将最后得这个节点的next指向新的节点
     */
    public SingledLinkedList() {
    }

    //获取头结点

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        //因为head节点不能动，所以需要辅助节点，帮助找到尾节点
        Node temp = head;

        //遍历链表找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果不是最后一个节点，把temp向后移动一位
            temp = temp.next;
        }
        //退出while循环时，temp就指向了链表的最后
        //把最后得节点的next指向新的节点
        temp.next = node;

    }

    //打印链表
    public void list() {
        //判断链表是否为null
        if (head.next == null) {
            System.out.println("list is null");
            return;
        }
        //因为head节点不能动，所以需要辅助节点，帮助找到尾节点
        Node temp = head;
        while (true) {
            //判断链表是否走到了最后
            if (temp == null) {
                break;
            }
            //打印链表信息
            System.out.println(temp);
            //继续遍历链表
            temp = temp.next;
        }
    }

    //指定位置添加Node节点
    public void addByOrder(Node node){
        //头结点不能动所以需要临街节点temp
        //因为是单链表，所以我们需要找到temp是位于添加位置之前的一个节点，否则插入不了
        Node temp=head;

        //flag表示添加的编号是否存在，默认为false
        boolean flag=false;
        while(true){
            //说明temp已经到链表已经走到了最后
            if(temp.next==null){
                break;
            }
            //找到了对应的位置，就在temp的后边插入数据
            if(temp.next.num>node.num){
                break;
             }else if (temp.next.num==node.num){//插入的位置已经存在
                flag=true;
                break;
            }
            //后移，遍历链表
            temp=temp.next;
        }
        //判断falg
        if(flag){
            System.out.println("该节点已近有数据，无法添加");
        }else {
            //添加节点
            node.next=temp.next;
            temp.next=node;
        }
    }
    //指定位置修改链表的内容
    public void updata(int num,Node node){
        //判断是否为null
        if(head.next==null){
            System.out.println("链表为null");
            return;
        }
        //根据节点编号num，找到需要修改的节点，
        //定义一个辅助变量
        Node temp=head;
        boolean flag=false;//表示是否找到该节点
        while(true){
            if(temp==null){
                break;//遍历链表结束，没有找到该节点
            }
            if(temp.num==node.num){
                //找到该节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag，判断是否修改节点内容
        if(flag){
            temp.name=node.name;
            temp.nickName=node.nickName;
        }else {
            System.out.println("没有找到该节点 "+node.num);
        }
    }

    //删除指定节点
    /*
    1. 我们先找到 需要删除的这个节点的前一个节点 temp
    2. temp.next = temp.next.next
    3. 被删除的节点，将不会有其它引用指向，会被垃圾回收机制回收
     */
    public void remove(int num){
        Node temp=head;
        boolean flag=false;//表示是否找到要删除的节点
        while(true){
            if (temp.next==null){//以及走到了链表的结尾
                break;
            }
            if(temp.next.num==num){
                //表示找到了删除节点的前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //判断flag
        if(flag){
            //找到了
            temp.next=temp.next.next;
        }else {
            System.out.println("要删除的节点不存在");
        }

    }

    //获取链表的节点个数
    public  int getLength(Node head){
        //判断链表是否为null
        if(head.next==null){
            return 0;
        }
        int length=0;
        //创建一个临时变量，遍历链表
        Node cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next;//遍历数组
        }
        return length;
    }

    //获取节点的倒数第K歌节点
    /*
    思路：
    1.接收head节点和一个index：k
    2.index 表示倒数第k个节点
    3.先从头到尾遍历链表，得到的总的长度，
    4.得到size 后，从第一个接地点开始遍历（size-index）个就是倒数第k个节点4
    5.找到了返回该节点，没有找到返回null

     */
    public Node findLastIndexNode(Node head, int index){
        //判断链表是否为null
        if(head.next==null){
            return null;//链表为空，没有找到
        }
        //第一次遍历得到节点的个数
        int length=getLength(head);
        //判断index的长度是否合法
        if(index<=0||index>length){
            return null;//index不合法，没找到
        }
        //第二次遍历，找到length-index的位置（我们要找的位置）
        //定义临时变量，for循环找到倒数index个位置
        Node cur=head.next;
        for(int i=0;i<length-index;i++){
            cur=cur.next;
        }
        return cur;
    }
       //单链表反转
    public void reverse(Node head){
        //判断链表是否为NUll,或者只有一个节点直接返回
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助变量，遍历链表
        Node cur=head.next;
        //定义给一个指向当前节点【cur】的下一个节点
        Node Next=cur.next;
        //定义一个新的节点做头结点
        Node reverseHead=new Node(0,"","");
        //表里原来的来表，每遍历一个节点将其取出，并放入新的链表reverseHea里面
        while(cur!=null){
            Next=cur.next;//西安保存当前节点的下一个节点
            cur.next=reverseHead.next;//将cur的下一个节点的指向新链表的最前边
            reverseHead.next=cur;//将cur连接到新的链表上
            cur=Next;
        }
        //将head.next指向reverseHead.next，实现单链表翻转
        head.next=reverseHead.next;
    }

    //从尾到头打印链表：使用栈
    public void reversePrint(Node head){
        //判断是否为空链表
        if(head.next==null){
            return;
        }
        //创建一个栈，将各个节点压入栈
        Stack<Node> stack=new Stack<Node>();
        Node cur=head.next;
        //将链表的节点都压入栈中
        while(cur!=null){
            stack.push(cur);//入栈
            cur=cur.next;//cur向后移动，这样可以把下一个节点压入栈中
        }
        //将栈中所有的节点进行打印，pop出栈
        while(stack.size()>0){
            System.out.println(stack.pop());//出栈
        }
    }


}

//定义Node节点，每个对象都是一个节点
class Node {
    public int num;
    public String name;
    public String nickName;
    public Node next;

    //构造器
    public Node(int num, String name, String nikeName) {
        this.name = name;
        this.num = num;
        this.nickName = nikeName;
    }


    //为了显示方法，覆写toString
    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}





































