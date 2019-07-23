package com.bite.doubleLinkedList;





public class doubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        DNode node1 = new DNode(1, "zhangsan", "张三");
        DNode node2 = new DNode(2, "zhangsan", "张三");
        DNode node3 = new DNode(3, "lisi", "张三");
        DNode node4 = new DNode(4, "zhangsan", "张三");
        //创建链表
        doubleLinkedList list1 = new doubleLinkedList();
        list1.add(node1);
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        list1.list();
        System.out.println();
        list1.remove(2);
        list1.list();
        System.out.println();
        DNode node5=new DNode(3,"wangwu","wangwu");
        list1.updata(2,node5);
        list1.list();

    }
}
    //定义SingleLinkedList
class doubleLinkedList {
        //先初始化一个头结点，头节点不能动，不放数据，只是为了能找到链表
        private DNode head = new DNode(0, "", "");

    /*

    添加数据到单链表

    思路：当不考虑编号顺序的时候
    1.找到当前链表的最后节点
    2.将最后得这个节点的next指向新的节点
     */

        public doubleLinkedList() {

        }
//获取头结点

        public DNode getHead() {
            return head;
        }

        //添加节点到最后
        public void add(DNode node) {
            //因为head节点不能动，所以需要辅助节点，帮助找到尾节点
            DNode temp = head;

            //遍历链表找到最后
            while (true) {
                if (temp.next == null) {
                    break;
                }
                //如果不是最后一个节点，把temp向后移动一位
                temp = temp.next;
            }
            //退出while循环时，temp就指向了链表的最后
            //形成双向链表
            temp.next = node;
            node.pre = temp;

        }

        //打印双向链表
        public void list() {
            //判断链表是否为null
            if (head.next == null) {
                System.out.println("list is null");
                return;
            }
            //因为head节点不能动，所以需要辅助节点，帮助找到尾节点
            DNode temp = head.next;
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
        public void addByOrder(DNode node) {
            //头结点不能动所以需要临街节点temp
            //因为是单链表，所以我们需要找到temp是位于添加位置之前的一个节点，否则插入不了
            DNode temp = head;

            //flag表示添加的编号是否存在，默认为false
            boolean flag = false;
            while (true) {
                //说明temp已经到链表已经走到了最后
                if (temp.next == null) {
                    break;
                }
                //找到了对应的位置，就在temp的后边插入数据
                if (temp.next.num > node.num) {
                    break;
                } else if (temp.next.num == node.num) {//插入的位置已经存在
                    flag = true;
                    break;
                }
                //后移，遍历链表
                temp = temp.next;
            }
            //判断falg
            if (flag) {
                System.out.println("该节点已近有数据，无法添加");
            } else {
                //添加节点
                node.next = temp.next;
                temp.next = node;
            }
        }

        //双向链表：指定位置修改链表的内容和单链表一样
        public void updata(int num,DNode node) {
            //判断是否为null
            if (head.next == null) {
                System.out.println("链表为null");
                return;
            }
            //根据节点编号num，找到需要修改的节点，
            //定义一个辅助变量
            DNode temp = head.next;
            boolean flag = false;//表示是否找到该节点
            while (true) {
                if (temp == null) {
                    break;//遍历链表结束，没有找到该节点
                }
                if (temp.num == node.num) {
                    //找到该节点
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag，判断是否修改节点内容
            if (flag) {
                temp.name = node.name;
                temp.nickName = node.nickName;
            } else {
                System.out.println("没有找到该节点 " + node.num);
            }
        }

        //双向链表：删除指定节点
    /*
    1. 对于双向链表，我们可以直接删除这个节点
    2.找到该节点进行自我删除
     */
        public void remove(int num) {
            //判断链表是否为null
            if (head.next == null) {
                System.out.println("链表为空~~");
                return;
            }
            DNode temp = head.next;
            boolean flag = false;//表示是否找到要删除的节点
            while (true) {
                if (temp.next == null) {//以及走到了链表的结尾
                    break;
                }
                if (temp.num == num) {
                    //表示找到了删除节点的前一个节点
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //判断flag
            if (flag) {
                //找到了
                //temp.next=temp.next.next;//单向链表
                temp.pre.next = temp.next;

                //如果是最后一个节点，不要执行下面的代码，否则出现空指针异常
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("要删除的节点不存在");
            }

        }

        //获取链表的节点个数
        public int getLength(DNode head) {
            //判断链表是否为null
            if (head.next == null) {
                return 0;
            }
            int length = 0;
            //创建一个临时变量，遍历链表
            DNode cur = head.next;
            //TODO
            return length;
        }


        //从尾到头打印链表：使用栈
        public void reversePrint(DNode head) {
            //判断是否为空链表
            if (head.next == null) {
                return;
            }
            //TODO
        }
    }

    //定义Node节点，每个对象都是一个节点
    class DNode {
        public int num;
        public String name;
        public String nickName;
        public DNode next;//指向下一个节点
        public DNode pre;//指向前一个节点

        //构造器
        public DNode(int num, String name, String nikeName) {
            this.name = name;
            this.num = num;
            this.nickName = nikeName;
        }

        //为了显示方法，覆写toString


        @Override
        public String toString() {
            return "DNode{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }





































