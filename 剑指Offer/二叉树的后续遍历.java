题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

二叉树的前序，中序，后序遍历参见这个博客https://blog.csdn.net/qq_40955824/article/details/89738830

后序遍历：先遍历左子树节点，在遍历右子树节点，最后遍历根节点

补充：

二叉查找树（Binary Search Tree）：（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。

举例：



算法思路：

1.先检查传进来的数组是否为空，为空返回false

2.数组不为空，先确定root；

3、遍历序列（除去root结点），从后向前遍历找到第一个小于root的位置，则该位置左边为左子树，右边为右子树；

4、遍历左子树，若发现有da于root的值，则直接返回false；

5、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence==null||sequence.length==0)//判断数组是否为空
            return false;
         return IsBSTree(sequence, 0, sequence.length-1);
    }
    public static boolean IsBSTree(int[] seq,int start,int end){
        if(start>end)
            return true;
        int root=end;
        //从后向前找比根节点小的数，从这个数开始，把数组分为两个部分，左子树和右子树
        while(root>start&&seq[root-1]>seq[root]){
            root--;
        }
        //对前半部分，从前先后找比根节点大的数，找到了说明不是搜索二叉树
        for(int j=0;j<root-1;j++){
            if(seq[j]>seq[end])
                return false;
        }
        return IsBSTree(seq,start,root-1)&&IsBSTree(seq,root,end-1);
    }
}