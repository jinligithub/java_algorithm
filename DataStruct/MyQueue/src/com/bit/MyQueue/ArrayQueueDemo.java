package com.bit.MyQueue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(3);
        char key=' ';
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:获取数据");
            System.out.println("h:查看队头数据");
            //接受一个字符
            key =sc.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int num=sc.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'g':
                    try{
                        int n=arrayQueue.getQueue();
                        System.out.println("获取数据"+n);
                    }catch (Exception e){
                        System.out.println("Queue is full");
                    }
                    break;
                case 'h':
                    try{
                        int n=arrayQueue.headQueue();
                        System.out.println("获取多头数据"+n);
                    }catch (Exception e){
                        System.out.println("Queue is full");
                    }

                    break;
                default:
                        break;
            }
            System.out.println("退出程序");
        }

    }

}
//使用数组模拟队列
class ArrayQueue{
    private int maxSize;//数组的最大容量，表示队列的最大容量
    private int front;//队头
    private int rear;//队尾
    private int[] arr;//用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;//队列的长度
        arr=new int[maxSize];
        front=-1;//指向队头部分;,它是指向队头的前一个位置
        rear=-1;//指向队尾，指向队尾的数据
    }
    //判断队列是否满了
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满了
        if(isFull()){
            System.out.println("Queue is full~~");
            return;
        }
        rear++;//raer后移
        arr[rear]=n;
    }

    //获取数据
    public int getQueue(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        front++;//front后移
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("Queue is full ");
            return;
        }
        //遍历数组
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头部
    public int headQueue(){
        //判断是否为null
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        //返回队头数据
        return arr[front+1];
    }
}
