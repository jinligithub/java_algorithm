题目描述：

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

算法描述：

1.先判断list1和list2 里面有没有空的链表，如果有直接返回另一条链表

2.创建新链表head ,然后当两个链表都不为空时，比较两个链表的元素大小，把里面小的值插入到新链表中，然后该节点对应的链表向后移动一位，继续下一轮比较。

3.当两个链表中有一个链表排序完成时，退出循环。然后把另一条还有元素的链表追加到head链表后边

4当两个链表都为空时，返回新链表head

非递归方法：

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if(list1==null)//第一个链表为空，直接返回第二个链表
                return list2;
            if(list2==null)//第二个链表为空，直接返回第一个链表
                return list1;
            ListNode head=null;//新链表
            ListNode cur=null;//新链表的当前节点
            while(list1!=null&&list2!=null){//当两个链表都不为空时，进行比较以及向新链表插入元素
                if(list1.val<=list2.val){//第一个链表的当前节点的值大于第二个链表当前节点的值
                    if(head==null){//判断是否为头结点
                        head=cur=list1;
                    }else{//不是头结点
                        cur.next=list1;//把当前元素插入到head链表中
                        cur=cur.next;//当节点指向刚刚插入的元素
                    }
                    list1=list1.next;//第一个链表的元素指向下一个待排序元素
                }else{//第二个链表的元素大于第一个链表的元素
                    if(head==null){//判断头结点是否为空
                        head=cur=list2;
                    }else{//头结点不为空
                        cur.next=list2;
                        cur=cur.next;
                    }
                    list2=list2.next;//第二个链表指向下一个带排序元素
                }
                if(list1==null){//判断list1后边是否还有元素，若没有直接给head链表追加剩下的list2元素
                    cur.next=list2;
                }
                if(list2==null){//判断list2后边是否还有元素，若没有直接给head链表追加剩下的list1元素
                    cur.next=list1;
                }
            }
            return head;
        }
        //递归写法
        public ListNode Merge2(ListNode list1,ListNode list2) {
            if(list1==null)//第一个链表为空，直接返回第二个链表
                return list2;
            if(list2==null)//第二个链表为空，直接返回第一个链表
                return list1;
            ListNode head=null;//新链表
            if(list1.val<=list2.val){//当list1里的元素，小于list2里的元素，把list1里的元素插入到head里
                head=list1;
                head.next=Merge2(list1.next,list2);
            }else{//当list1里的元素，大于list2里的元素，把list2里的元素插入到head里
                head=list2;
                head.next=Merge2(list1,list2.next);
            }
            return head;
        }
    }
