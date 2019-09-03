package com.bite.VIPKID;/*
寻找zero 组数
        时间限制：C/C++语言 1000MS；其他语言 3000MS
        内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
        给定一个整数的数组，找出其中的pair(a,  b)，使得a+b=0，并返回这样的pair数目。（a,  b）和(b,  a)是同一组。

        输入
        整数数组

        输出
        找到的pair数目


        样例输入
        -1,  2,   4,  5,  -2
        样例输出
        1
 */
import java.util.*;
public class Zero{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(",");
        int[] arr=new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        //  String s=new String();
        List<Integer> list=new ArrayList<>();

        HashMap<Integer,Integer>  map=new HashMap<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if((map.get(arr[i])==null)&&(map.get(arr[j])==null)){
                    if((arr[i]+arr[j]==0)){
                        map.put(arr[i],1);
                        map.put(arr[j],1);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}