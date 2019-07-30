package com.bit;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int  array[]={101,34,119,1};
        insertsort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertsort(int[] array){
        for (int i = 1; i <array.length ; i++) {//外部排序的册数
           //定义要插入的数
            int insertVal=array[i];
            //保存要插入数的前一个下标
            int insertindex=i-1;
            /*
            向前找到要插入的位置
            说明：
            1.insertIndex>=0  保证在找到insertVal位置时，不越界
            2.insettVal<array[insertIndex]:待插入的数还没有找到插入的位置
            3.需要将insertIndex向前移动向到要插入的位置

            注意：如果小下昂从达到小排列：insertVal>array[insertindex]
             */
            while(insertindex>=0&&insertVal<array[insertindex]){//从小到大排序
                array[insertindex+1]=array[insertindex];
                insertindex--;
            }
            //当退出while循环时，说明插入的位置已经找到了，insertIndex+1
            //如果在对应的位置就不需要复值
            if(insertindex+1!=i){
                array[insertindex+1]=insertVal;
            }
        }
    }
}
