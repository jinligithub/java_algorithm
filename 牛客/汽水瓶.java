题目描述

有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水
，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？

输入

输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。

输出

对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。


样例输入
3
10
81
0

样例输出
1
5
40
0
--------------------- 

方法一：找规律
   3  10  81  0  4  20
   1  5   40  0  1  10
   有上面可以得出喝的汽水瓶数n，就等于n/2
   
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
			//当瓶子数为0时，直接输出0
            if(num==0){
                System.out.println(0);
			
            }else{
				//当瓶子数>0时，直接返回瓶子数的一半n/2
                System.out.println(num/2);
            }
        }
    }
}

方法二：递归
因为他是三个瓶子可以换一瓶水，而两个瓶子可以向老板借一瓶水，从而在多喝一瓶水。
所以每一次喝完的瓶子数为 num=num/3+num%3,而每次喝的汽水数目count=num/3,所以喝的总的汽水数目为count=num/3+count;


import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if(num==0){
                System.out.println(0);
            }
            int count=0;
            while(num/3>=1){
                count=num/3+count;
                num=num/3+num%3;
            }
            if(num==2){
                count++;
            }
            System.out.println(count);
        }
    }
}
