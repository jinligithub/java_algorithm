package com.bit;

import java.util.Arrays;

public class shellSort {
    public static void main(String[] args) {
        int  array[]={101,34,119,1};
        shellSort2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array){
        //排序的趟数
        for (int gap=array.length/2; gap >0 ; gap/=2) {
            //对数组进行分组，在对gap组元素进行直接插入排序
            for (int i = gap; i <array.length ;i++) {
                //遍历各组中所有的元素（一共gap组，有array.length/gap个元素），步长为gap
                for (int j=i-gap ; j >=0 ; j-=gap) {
                    //如果当前元素大于加上步长之后放入元素，说明交换
                    //把条件改为array[j] < array[j+gap]，就实现了从大到小排序
                    if (array[j] > array[j+gap]) {//从小到大排序
                        int temp=array[j];
                        array[j]=array[j+gap];
                        array[j+gap]=temp;
                    }

                }

            }

        }
    }
    //移位法
    public static void shellSort2(int[] array){
        //排序的趟数，增量gap,并且逐个部缩小增量
        for(int gap=array.length/2;gap>0;gap/=2){
            //对gap个组，逐个对其所在的组进行直接插入排序
            for(int i=gap;i<array.length;i++){
                int j=i;//记录袋插入的位置
                int temp=array[j];//保存待插入的值
                if(array[j]<array[j-gap]){//后边的数如果小于前边的数，就去找要插入的位置
                    while(j-gap>=0&&temp<array[j-gap]){//对每一组的元素进行排序，小的在前，大的在后
                        //移动
                        array[j]=array[j-gap];
                        j-=gap;//向前找要插入的位置
                    }
                    //退出while循环的时候，就给temp找到要插入的位置
                    array[j]=temp;
                }
            }
        }
    }

    public static void shellSort3(int[] arr, int length) {
        for(int gap=length/2;gap>0;gap/=2){//排序的的趟数
            for(int i=0;i<length-gap;i++){//根据gap，分成几个小的数组进行排序
                int end=i;
                int tmp=arr[end+gap];
                while(end>=0&&arr[end]>tmp){//对每一组的元素进行排序，小的在前，大的在后
                    arr[end+gap]=arr[end];
                    end-=gap;//向前找属于它的位置
                }
                arr[end+gap]=tmp;//end+gap，因为在循环里end-gap了，所以这里补上gap
            }
        }
    }
}
