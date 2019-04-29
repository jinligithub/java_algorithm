题目描述
输入一个链表，反转链表后，输出新链表的表头。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/


方法一：循环的改变链表的指向
public class Solution {
        public ListNode ReverseList(ListNode head) {
            //判断链表为空
            if(head == null)
                return null;
            //指向head的前一个节点
            ListNode pre=null;
            //指向head的想一个节点，用于保存下一个节点后的链表
            ListNode next=null;
            while(head!=null){
                //用于保存head之后的链表
                next=head.next;
                //改变头结点的指向
                head.next=pre;
                //让pre和head指向同一个节点
                pre=head;
                //让head和next指向同一个节点
                head=next;
        }
        return pre;
    }
}