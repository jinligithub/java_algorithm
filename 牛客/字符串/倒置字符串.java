package com.bit;

import java.util.Scanner;
/*
链接：https://www.nowcoder.com/questionTerminal/ee5de2e7c45a46a090c1ced2fdc62355
来源：牛客网

将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I

输入描述:
每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100


输出描述:
依次输出倒置之后的字符串,以空格分割
示例1
输入
I like beijing.
输出
beijing. like I
 */

public class ReverseString {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String sc=in.nextLine();
        //String[] str=in.split(" ");
        String[] str = sc.split(" ");
        for(int i=str.length-1;i>=0;i--){
            if(i==0){
                System.out.print(str[i]);
            }else{
                System.out.print(str[i]+" ");
            }
        }
    }
    public  static void reverse(){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]).append(" ");
        }
        String result=sb.toString().trim();
        System.out.println(result);
    }
}
