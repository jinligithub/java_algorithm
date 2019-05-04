题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

算法分析：

题目的意思就是判断一个树，是不是另一个树的子结构

1.在A中去找和B树根节点的值相同的节点，找不到，那么B树不是A树的子树，找到了进入2

2.根据在A中找到的根节点，分别去判断它的左右子树是否和B树的左右子树相同，

1）当在A中找到了 和B根节点一样的节点，则继续判断A的左右子树和B的左右子树的节点是否一样，如果一样，则B树是A的子树

2）如果不一样，则继续在A中寻找是否还有和B树根节点一样的数字，如果有继续判断他的左右子树是否和B树的左右子树一样，一样则是子树，不一样重复步骤2）



即判断一个树是不是另一个树的子树需要判断两方面的内容：树的结构和节点对应的值是否相等（缺一不可）

如果节点里面的值相同但是结构不一样，那就不是他的子树B是A的子树

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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)//空树不是任意一个树的子树
            return false;
        if(root1==null&&root2!=null)//空树不是任何树的父树
            return false;
        boolean flag=false;
        if(root1.val==root2.val){//先判断根节点是否和子树的根节点一样
            flag=isSubTree(root1,root2);
        }
        if(!flag){//去左子树找和子树根节点一样的节点
                flag=HasSubtree(root1.left,root2);
            if(!flag){//左子树没找到，去右子树找，
                flag=HasSubtree(root1.right,root2);
            }
        }
        return flag;
    }
    public static boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2==null)//此时说明子树的节点已经走完了，B是A的子树
            return true;
        if(root1==null&&root2!=null)//此时说明子树还没有走完，但是A树已经走完了，B不是A的子树所以不是子树
            return false;
        if(root1.val==root2.val){//找到了相同的节点，去判断左右子树里的结构和数值是否相同
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;//说明B不是A的子树
        }
    }
}



