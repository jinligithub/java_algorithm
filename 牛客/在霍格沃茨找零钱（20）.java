链接：https://www.nowcoder.com/questionTerminal/58e7779c9f4e413cb80792d33ba6acaf
来源：牛客网

[编程题]在霍格沃茨找零钱（20）
热度指数：6234时间限制：1秒空间限制：32768K

如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 
就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，
二十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，
你的任务是写一个程序来计算他应该被找的零钱。

输入描述:
输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，
其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0, 17)区间内的整数，
Knut是[0, 29)区间内的整数。


输出描述:
在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
示例1
输入
10.16.27 14.1.28
输出
3.2.1

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String p=in.next();//next()方法读到空格停止，nextLine()读到换行停止
        String a=in.next();
        String[] pMoney=p.split("\\.");//利用split()方法将他拆分成String[]数组
        String[] aMoney=a.split("\\.");
		//计算对应的值，第一位*17*29+第二位*29+第三位
        int pTotal=Integer.valueOf(pMoney[0])*17*29+Integer.valueOf(pMoney[1])*29+Integer.valueOf(pMoney[2]);
        int aTotal=Integer.valueOf(aMoney[0])*17*29+Integer.valueOf(aMoney[1])*29+Integer.valueOf(aMoney[2]);
        int key=1;
		//计算差值
        int value=aTotal-pTotal;
		//如果计算结果为负数，把value置为负数
        if(value<0){
            value=-value;
            key=-key;
        }
		//计算对应位数的值
        int p1=value/(17*29);
        int p2=(value-p1*17*29)/29;
        int p3=value-p1*29*17-p2*29;
		//结果的正负数
        p1*=key;
        System.out.println(p1+"."+p2+"."+p3);

    }
}
