题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。


方法一：用冒泡的方法，把相邻的奇数放前边去，把偶数放后边来
public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
}



方法二：新建一个数组，把奇数全部存到新数组里。再把原数组里的奇数删掉，
最后再把旧数组里的偶数添加到新数组里


方法三：
public class Solution {
    public void reOrderArray(int [] array) {
       for(int i=1;i<array.length;i++){
            int target = array[i];
            if(array[i] % 2 == 1){
                int j = i;
                while(j >= 1 && array[j-1] % 2 == 0){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = target;
            }
        }
    }
}