题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

解题思路：
1.因为输入进去的是一个非减的排序数组，即也就是一个递增的数组。

2.所以只要找到旋转过的数字里面的最小值就好，而且因为数组是递增的，所以最小的旋转数字一定最先旋转，即在旋转数字里排在最前边。

方法一：

从前向后遍历，只要前一个数大于后一个数，即array[i]>array[i+1]时，那么array[i+1]就是需安装的最小数字

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)//数组为空，直接返回0
            return 0;
        if(array.length==1)//数组只有一个元素，直接返回
            return array[0];
        for(int i=0;i<array.length;i++){//从前向后找后一个数比前一个数小的数字
            if(array[i]>array[i+1]){
                return array[i+1];//找到了直接返回
            }
        }
        return 0;//没找到，返回0
    }
}
 
 

方法二：二分法查找

采用二分法解答这个问题，

mid = low + (high - low)/2

需要考虑三种情况：

(1)array[mid] > array[high]:

出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。

low = mid + 1

(2)array[mid] == array[high]:

出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边

还是右边,这时只好一个一个试 ，

high = high - 1

(3)array[mid] < array[high]:

出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左

边。因为右边必然都是递增的。

high = mid

注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字

比如 array = [3,6]

array[low] = 3 ;array[mid] = 3 ; array[high] = 6 ;

如果high = mid - 1，就会产生错误， 因此high = mid

但情形(1)中low = mid + 1就不会错误

 

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //二分法查找
        if(array.length==0)//数组为空，直接返回0
            return 0;
        if(array.length==1)//数组只有一个元素，直接返回
            return array[0];
        int low=0;
        int high=array.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[mid]>array[high]){//此时最小数在右边
                low=mid+1;
            }else if(array[mid]==array[high]){//此时
                high=high-1;
            }else{//此时最小数在左边
                high=mid;
            }
        }
        return array[low];
    }
}
 
 
