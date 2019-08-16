package com.bite.科大飞讯;

import java.util.Arrays;
import java.util.Scanner;
/*
利用二分查找的飞过方法查找一个数
 */
public class BinFind {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(",");
        int key =sc.nextInt();
        int[] arr=new int[str.length];
        for (int i = 0; i <str.length ; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }

        System.out.println(BinaryFind(arr,key,0,arr.length-1));

    }
    public static int BinaryFind(int[] arr,int key,int start,int end){
        int mid=(start+end)/2;
        if(start>end){
            return -1;
        }
        if(key<arr[mid]){
            return BinaryFind(arr,key,start,mid-1);
        }else if(key>arr[mid]){
            return BinaryFind(arr,key,mid+1,end);
        }else if(key==arr[mid]) {
            return mid+1;
        }else {
            return -1;
        }
    }
}
