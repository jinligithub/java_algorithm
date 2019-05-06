题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

举例：

如果给如图的二叉树，题目的要求就是把二叉树的节点按每一层输出



算法思想：

1.我们可以借助双端队列，来保存二叉树的节点，用一个链表来保存每一层二叉树节点里的值

2.当二叉树为空时，直接返回链表（此时，链表为空，但是不能直接返回null因为回报nullPointException异常）。

如果二叉树不为空，直接把二叉树的根节点入双端队列，

3.当双端对不为空时，把该节点出双端队列，并且把改节点里的值放入链表List里面 。然后该每个节点有没有左右子节点，如果有把左右子节点入双端队列，

4.当双端队列为空时，说明二叉树遍历完成

 

补充：

Deque是Queue的子接口,Queue是一种队列形式,而Deque则是双向队列,它支持从两个端点方向检索和插入元素,因此Deque既可以支持LIFO形式也可以支持LIFO形式.Deque接口是一种比Stack和Vector更为丰富的抽象数据形式,因为它同时实现了以上两者。

Deque常用方法：

boolean	add(E e)
将指定的元素插入此双端队列表示的队列中（换句话说，在此双端队列的尾部），如果它是立即可行且不会违反容量限制，返回 true在成功时和抛出 IllegalStateException如果当前没有空间可用的。

boolean	contains(Object o)
如果此deque包含指定的元素，则返回 true 。

E	element()
检索但不删除由此deque表示的队列的头部（换句话说，该deque的第一个元素）。

E	getFirst()
检索，但不删除，这个deque的第一个元素。

E	getLast()
检索，但不删除，这个deque的最后一个元素。

boolean	offer(E e)
将指定的元素插入由此deque表示的队列（换句话说，在该deque的尾部），如果可以立即执行，而不违反容量限制， true在成功时 false如果当前没有可用空间，则返回false。

E	peek()
检索但不删除由此deque表示的队列的头部（换句话说，此deque的第一个元素），如果此deque为空，则返回 null 。

E	poll()
检索并删除由此deque（换句话说，此deque的第一个元素）表示的队列的 null如果此deque为空，则返回 null 。

E	pop()
从这个deque表示的堆栈中弹出一个元素。

void	push(E e)
将元素推送到由此deque表示的堆栈（换句话说，在此deque的头部），如果可以立即执行此操作而不违反容量限制，则抛出 IllegalStateException如果当前没有可用空间）。

boolean	remove(Object o)
从此deque中删除指定元素的第一个出现。

int	size()
返回此deque中的元素数。

import java.util.ArrayList;
import java.util.Deque;//双端队列
import java.util.LinkedList;
 
 
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list =new ArrayList<Integer>();//创建一个list列表
        Deque<TreeNode> deque=new LinkedList<TreeNode>();//创建一个双端队列
        if(root==null)//当二叉树为空二叉树时，直接返回空列表
            return list;
        deque.add(root);//把二叉树的根节点入双端队列
        while(!deque.isEmpty()){//如果双端队列不为空，进去读取双端队列里 左右子树的节点 
            TreeNode tmp=deque.pop();//保存出队节点
            list.add(tmp.val);//把出队节点里面的值添加到list里
            //若左右节点不为空把左右节点入双端队列
            if(tmp.left!=null)
                deque.add(tmp.left);
            if(tmp.right!=null)
                deque.add(tmp.right);
        }
        return list;
    }
}
 
