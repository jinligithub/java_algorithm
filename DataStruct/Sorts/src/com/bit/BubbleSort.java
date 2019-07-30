package com.bit;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int array[]={3,9,-1,10,20};
        sort(array);
        //print(array);
        System.out.println(Arrays.toString(array));

    }
    public static void sort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {//排序的次数
            boolean flag=false;//标示变量，表示是否进行交换过
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){//在一堂排序中，一次都没有交换过
                break;
            }
        }
    }

    public static void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
