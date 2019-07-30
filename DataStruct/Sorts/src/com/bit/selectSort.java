package com.bit;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
       int  array[]={101,34,119,1};
       SelectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void SelectSort(int[] array){

        for (int i = 0; i <array.length-1 ; i++) {//排序的趟数
            int maxindex=i;//记录最小值的位置
            int max=array[i];//记录最小值
            for (int j = i+1; j <array.length; j++) {//找到最大值进行交换
                //如果改为max<array[j]:就是把最大的放在最前边排序
                if(max>array[j]){//说明后一个数比前一个数大
                    maxindex=j;//重置min
                    max=array[j];//重置minindex
                }
            }

            if(maxindex!=i){//如果最大的数，没有在对应的位置才进行交换
                array[maxindex]=array[i];
                array[i]=max;
            }
        }

    }
}

