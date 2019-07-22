package com.bit.Calculator;

public class Calculator {
    public static void main(String[] args) {

        String exp = "30+2*6-2";
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepnum="";//用于拼接多数字 的
        char ch = ' ';//把每次扫描的char保存到ch
        //使用while循环表达式exp
        while (true) {
            //一次得到exp的每个字符
            //把String转为charAt()转为字符
            ch = exp.substring(index, index + 1).charAt(0);
            //判断ch
            if (operStack.isOper(ch)) {//如果是字符串
                //判断当前符号栈是否诶空
                if (!operStack.isEmpty()) {
                    //判断当前的符号栈是否为null,如果当前的操作符的优先级小于或者等于栈中的操作符，需要从栈中pop出两个数
                    //在符号栈中pop出一个符号，进行运算，得到相应的结果，把结果入栈，然后把当前ed符号入栈
                    if (operStack.Priority(ch) <= operStack.Priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果入栈
                        numStack.push(res);
                        //把当前符号入栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于操作符栈的优先级，直接入栈
                        operStack.push(ch);
                    }

                } else {
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            } else {
                //如果是数字直接入数字栈
                //ch-48：因为ASCII的值与字符的值不一致
                /*
                修改：
                1.当处理多为数时，不能发现是一个数就立即入栈，因为会出现多位数的情况
                2.在处理数时需要向后exp的表达式的后边在看一位，若果是数就继续扫描，否则入栈
                3.定义一个字符串变量，永固拼接字符串
                 */
                keepnum+=ch;
                //如果ch已经是exp的最后一个数了，直接入栈
                if(index==exp.length()-1){
                    numStack.push(Integer.parseInt((keepnum)));
                }else {
                    //判断下一个字符是不是数字，如果是数字继续扫描，如果不是就入栈
                    //注意后一位，不是操作符，index++
                    if(operStack.isOper(exp.substring(index+1,index+2).charAt(0))){
                        //如果后一位是一个运算符，就入栈
                        numStack.push(Integer.parseInt(keepnum));
                        //重要！！：入栈后把keepNum清空
                        keepnum="";
                    }
                }
            }
            index++;
            //让index+1,并且判断是否扫描到exp的最后了
            if (index >= exp.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数字和符号栈pop出对应的数字和符号，并计算
        while (true) {
            //如果符号栈为空，计算最后得结果，数栈中只有一个结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("结果是" + res);
    }
}

//创建一个栈
class ArrayStack2{
    private  int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，
    private int top=-1;
    //构造器
    public ArrayStack2(int maxSize){
        this.maxSize=maxSize;//设置栈的大小
        stack=new int[this.maxSize];//初始化栈
    }
    //获取栈顶的值
    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否满了
        if(isFull()){
            System.out.println("栈满了~~");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈
    public int pop(){
        //先判断栈是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("stack is empty");
        }
        //先保存栈顶数据
        int value =stack[top];
        top--;//栈向下以移动一位
        return value;
    }

    //遍历栈,遍历时从栈顶开始显示数据
    public  void list(){
        //判断栈是否为空
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        //从栈顶开始遍历栈
        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级，优先级使用数字表示，数字越大优先级越高
    public int Priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        } else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;//假设的操作符，只有加减乘除
        }
    }
    //判断是不是一个操作符号
    public boolean isOper(char value){
        return value=='+'||value=='-'||value=='*'||value=='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;//用于存放数据额的结果
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case  '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                    break;
        }
        return res;
    }
}