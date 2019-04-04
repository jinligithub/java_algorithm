题目描述大家都知道斐波那契数列，现在要求输入一个整数n，
请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
方法一：利用递归

public class Solution {
    public int Fibonacci(int n) {       
/////////////////////////////////////////////////////////////////////////
 //利用递归
        //判断是0的情况//
        if(n==0)
            return 0;
        //判断是1或2的情况
        if(n==1||n==2)
            return 1;
        //判断大于2的情况
        else
            return Fibonacci(n-1)+Fibonacci(n-2);
    }

方法二：利用非递归方法进行计算，利用三个数来进行运算，当n>3时，第三个数=第一个数+第二个数
第一个数=第二个数
第二个数=第三个数
//////////////////////////////////////////////////////////////////////
  //利用非递归的方法，第一三个数
      public int Fibonacci(int n) {
        int num1=1;
        int num2=1;
        int result=0;
        if(n==1||n==2){
            return 1;
        }else{
            for(int i=3;i<=n;i++){
                result=num1+num2;
                num1=num2;
                num2=result;
            }
            return result;
        }
	}

