二维数组打印

链接：https://www.nowcoder.com/questionTerminal/6fadc1dac83a443c9434f350a5803b51
来源：牛客网

有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。

给定一个二位数组arr及题目中的参数n，请返回结果数组。

测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]



方法一：

import java.util.*;

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] tmp=new int[n*n];
        int index=0;
        int startX=0;
        int startY=n-1;
        while(startX<n){
			//定义了右上角的元素
            int x=startX;
            int y=startY;
			//
            while(x<n&&y<n){
                tmp[index++]=arr[x++][y++];
			}
            if(startY>0)
                startY--;
            else
                startX++;
        }
        return tmp;
    }
}

方法二：右上角和左上角同时打印

import java.util.*;
 
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] A = new int[n*n];
        int p = 0;
        for(int p1=n-1;p1>-1;p1--){
            for(int p2=0;p2<n-p1;p2++){//当x大于n-p1时结束本次循环
                A[p] = arr[p2][p1+p2];//打印右上角的元素
                A[n*n-1-p] = arr[n-1-p2][n-1-p1-p2];//打印左下角对应元素，[n-1-p2][n-1-p1-p2]->左下角位置
                p++;
            } 
        }
        return A;
    }
}