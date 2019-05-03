题目描述
输入一个链表，输出该链表中倒数第k个结点。

 

思路：

1.利用快慢指针方法，让快的指针先走k个节点

2.然后让慢的指针再和快指针一起走，当快指针为null时，说明已经走到了链表的末尾，

3.此时慢指针就是当前的第k个节点

方法一：快慢指针法

/*
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<0)//判断链表为空
            return null ;
        ListNode fast=head;//快指针
        ListNode slow=head;//慢指针
        while(k>0){//让快指针先走k步
            if(fast==null)//如果此时还没到达k个节点链表就为空，说明没有k个节点
                return null;
            fast=fast.next;
            k--;
        }
        while(fast!=null){//快慢指针一起走，当快指针我null时，说明到达链表的末尾
            fast=fast.next;
            slow=slow.next;
        }
        return slow;//此时慢指针指向k个节点，返回慢指针
    }
}
 

方法二：利用一个循环解决问题，在这个循环里面判断k<n，k>n的情况，并且找到第k个节点，如果找不到，返回null

/*
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null|| k<=0)//判断head和k<0为，返回null的情况
            return null;
        ListNode cur = head; //处理长度的第一个指针
        int n = 0; //链表长度
        ListNode node= null; //记录距离结尾K长度的node
        while(cur!=null){
            n++;
            if(n == k)
                 node = head;//当长度超过k的时候，才有值
            if(n>k)
                 node = node.next; //当N长度大于k的时候，每一次for循环前移
             cur = cur.next; //处理长度的指针前移
         }
        return node; //for循环结束，得到的距离k的Node，可以为空
    }
}
 