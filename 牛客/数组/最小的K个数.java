链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf
来源：牛客网

[编程题]最小的K个数
热度指数：507866时间限制：1秒空间限制：32768K
算法知识视频讲解
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>(k);
        if(input==null||input.length==0||k<=0)
            return list;
        if(k>input.length){
            return list;
        }
        for(int i=0;i<k;i++){//找K个最小的数字，循环K次
            for(int j=0;j<input.length-i-1;j++){//每一趟把最小的数放在最后
                if(input[j]<input[j+1]){
                   int min=input[j];
                    input[j]=input[j+1];
                    input[j+1]=min;
                }
            }
            list.add(input[input.length-i-1]);
        }
        return list;
    }
}