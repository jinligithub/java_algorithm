### 找出其中的第k小的结点

## 题目描述

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

##### 思路：

1. 二叉搜索树的左子树时大于右子树的，而且二叉的的中序遍历的是有序的：左-》根 -》右

2. 这样找到二叉搜索树的最左边节点，然后输出K个就是第K个小的数据

```java
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<0)//判断节点是否为null，以及K是否小于0
            return null;
        Stack<TreeNode> stack=new Stack<>();//创建一个栈来保存节点
        TreeNode temp=pRoot;//创建临时节点，遍历二叉搜索树
        int count=1;//计数器，当计数器为K时就把该节点返回
        while(temp!=null||!stack.isEmpty()){//当当前节点不为null，或者栈不为null时
            if(temp!=null){//如果当前节点不为null，把该 节点入栈。向左找最小的值
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();//把节点出栈，当计数器等于K时把该节点返回
                if(k==count){
                    return temp;
                }
                count++;
                temp=temp.right;//向右找节点
            }

        }
        return null;//没找到该节点，返回null
    }
}
```