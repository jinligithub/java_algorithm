链接：https://www.nowcoder.com/questionTerminal/4b733a850c364c32b368555c8c2ec96b?toCommentId=2845379
来源：牛客网

[编程题]球的半径和体积
热度指数：11225时间限制：1秒空间限制：65536K

输入球的中心点和球上某一点的坐标，计算球的半径和体积

输入描述:
球的中心点和球上某一点的坐标，以如下形式输入：x0 y0 z0 x1 y1 z1

输出描述:
输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数

为避免精度问题，PI值请使用arccos(-1)。
示例1
输入
0 0 0 1 1 1 
输出
1.732 21.766

思路：直接利用公式进行计算
R=/(x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
V=(4*PI*R*R*R)/3.0


import java.util.Scanner;
import static java.lang.Math.PI;
public class Main{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
		//Integer.valueOf(String s):把String数组专户为int 或double类型
        double x0=Integer.valueOf(in.next());
        double y0=Integer.valueOf(in.next());
        double z0=Integer.valueOf(in.next());
        double x1=Integer.valueOf(in.next());
        double y1=Integer.valueOf(in.next());
        double z1=Integer.valueOf(in.next());
        double R=0.0;
        double V=0.0;
		//直接利用公式进行计算
        R=Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0));
        V=(4*PI*R*R*R)/3.0;
		//第一种输出方式
        System.out.printf("%.3f",R);
        System.out.printf(" ");
        System.out.printf("%.3f\n",V);
		//第二种输出方式(格式化输出)
        //System.out.format("%.3f %.3f",R,V);
    
    }
}