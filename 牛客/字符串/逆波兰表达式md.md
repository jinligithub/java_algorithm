逆波兰表达式：

1. 从左到右顺序扫描整个后缀表达式；

2. 如果是操作数，则将该操作数压入到栈中；

3. 如果是操作符，则从栈中弹出对应的操作数，注意操作数的顺序；根据操作符进行运算，并将结果重新压入到栈中；

4. 直至将整个栈扫描完毕；

5. 如果后缀表达式是合法的，则扫描完毕后，栈中只有一个元素，该元素的值即为后缀表达式的结果。
   

```Java
package com.bite.SenseTime;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(str[i]+"");
        }
        String s2=sb.toString();
        System.out.println(BolanCaculate(s2));

    }
    public static int BolanCaculate(String str){
        Stack<String> stack=new Stack<>();
        //char[] arr=str.toCharArray();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='0'&&ch<='9'){
                stack.push(ch+"");
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                if(ch=='+'){
                    stack.push((num1+num2)+"");
                }else if(ch=='-'){
                    stack.push((num1-num2)+"");
                }else if(ch=='*'){
                    stack.push((num1*num2)+"");
                }else {
                    if(num2==0){
                        throw  new RuntimeException("zero is Exception");
                    }
                    stack.push((num1/num2)+"");
                }
            }
        }
        int result=Integer.parseInt(stack.pop());
        return result;
    }
}
```