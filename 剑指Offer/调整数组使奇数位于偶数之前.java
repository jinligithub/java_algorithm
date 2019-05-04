题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。

思路：

因为它要保证奇数和偶数的前后顺序，所以它是要求稳定性的

1，插排
2，冒泡排
3，快排不稳定，不适用于这道题
4，新建一个数组，空间换时间


方法一：用冒泡的方法，把相邻的奇数放前边去，把偶数放后边来

public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){//当前一个数为偶数，后一个数为奇数时才进行交换
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
}

方法二：
找到一个奇数后就向前找，看看有没有偶数，如果找到了就进行交换。

public class Solution {
    public void reOrderArray(int [] array) {
       for(int i=1;i<array.length;i++){//i=1因为假设第i个数为奇数，从1开始，可以向前和偶数交换
            int target = array[i];
            if(array[i] % 2 == 1){//从前向后找奇数
                int j = i;
                while(j >= 1 && array[j-1] % 2 == 0){//找奇数前边的偶数进行交换
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = target;
            }
        }
    }
}
方法三：可以新建一个数组，把奇数全部存到新数组里。再把原数组里的奇数删掉，
最后再把旧数组里的偶数添加到新数组里（但是很麻烦，牵扯到很多数字的移动，如果数据特别多效率很低），相当于拿空间换时间
