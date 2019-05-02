题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和
中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

 

知识点：

二叉树的遍历0：通常有前序，中序和后续三种。

前序遍历：根-左-右，就是遍历树的时候，先遍历根节点然后再遍历左子节点最后遍历根节点的右子节点。

中序遍历：左-根-右，就是遍历树的时候，先遍历左子节点，然后再遍历其根节点，最后在遍历树的右子节点。

后序遍历：左-右-根，就是遍历树的时候，先遍历左子节点，然后再遍历其右子节点，最后在遍历这棵树的根节点。

注：前序，中序，后序是相对于根节点来说的（根在前，根在中间，根在后），其中左右子节点的顺序不会变。
 

首先，前序遍历的第一个元素一定是整棵树的根节点，而在中序遍历中，输出在根节点前面的，
一定是根节点的左子树所包含的节点，输出在根节点后面的一定是根节点右子树所包含的节点。

方法：递归
 
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre.length == 0||in.length == 0){//递归的出口，
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);//创建新的二叉树
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                 //递归左子树
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                 //递归右子树
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;
    }
}
 
​
