��Ŀ����
����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��

��������ǰ�����򣬺�������μ��������https://blog.csdn.net/qq_40955824/article/details/89738830

����������ȱ����������ڵ㣬�ڱ����������ڵ㣬���������ڵ�

���䣺

�����������Binary Search Tree�������֣���������������������������������һ�ÿ����������Ǿ����������ʵĶ������� ���������������գ��������������н���ֵ��С�����ĸ�����ֵ�� ���������������գ��������������н���ֵ���������ĸ�����ֵ�� ������������Ҳ�ֱ�Ϊ������������

������



�㷨˼·��

1.�ȼ�鴫�����������Ƿ�Ϊ�գ�Ϊ�շ���false

2.���鲻Ϊ�գ���ȷ��root��

3���������У���ȥroot��㣩���Ӻ���ǰ�����ҵ���һ��С��root��λ�ã����λ�����Ϊ���������ұ�Ϊ��������

4����������������������da��root��ֵ����ֱ�ӷ���false��

5���ֱ��ж����������������Ƿ����Ƕ��������������ݹ鲽��1��2��3����

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence==null||sequence.length==0)//�ж������Ƿ�Ϊ��
            return false;
         return IsBSTree(sequence, 0, sequence.length-1);
    }
    public static boolean IsBSTree(int[] seq,int start,int end){
        if(start>end)
            return true;
        int root=end;
        //�Ӻ���ǰ�ұȸ��ڵ�С���������������ʼ���������Ϊ�������֣���������������
        while(root>start&&seq[root-1]>seq[root]){
            root--;
        }
        //��ǰ�벿�֣���ǰ�Ⱥ��ұȸ��ڵ��������ҵ���˵����������������
        for(int j=0;j<root-1;j++){
            if(seq[j]>seq[end])
                return false;
        }
        return IsBSTree(seq,start,root-1)&&IsBSTree(seq,root,end-1);
    }
}