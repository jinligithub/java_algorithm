package com.bite;

public class Queue8 {
    //定义一个max表示有几个皇后
    int max=8;
    //定义数组保存皇后的位置
    int[] array=new int[max];

    //统计次数
    int count=0;
    public static void main(String[] args) {
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.println(queue8.count);

    }

    //放置第n个皇后
    //注意：check是每一次递归调用的时，进入到check（）中都有for(int i=0;i<max;i++),因此会有回溯
    public void check(int n) {
        if(n==max) {//n=8, 八个皇后度偶已经放好了
            print();
            count++;
            return;
        }
        //依次放入皇后，并且判断是否冲突
        for (int i = 0; i <max ; i++) {
            //先把当前的皇后n,放到该行的第一列
            array[n]=i;
            //判断 当前放置的第n个皇后放到第i列时是否有冲突
            if(judge(n)){//不冲突
                //接着放置n+1个皇后，即开始递归
                check(n+1);
            }
            //如果有冲突，就继续执行array[n]=i,即din个皇后，放置在本行后移一个位置

        }
    }

    //查看当前放置的第n个皇后，就去检测该皇后是否和前面百放好的皇后冲突
    private boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            //1.array[i]==array[n]表示第n个皇后是否和前面的n-1个皇后冲突
            //Math.abs(n-i)==Math.abs(array[n]-array[i]),表示判断第n个皇后是否和第i个皇后在同一斜线
            /*
            举例子：
            n=1  放在第二列 1   n=1 array[1]=1
            Math.abs(1-0)==1   Math.abs(array[n]-array[i])==Math.abs(1-0)=1
             */

            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }


    //定义一个方法，把皇后的位置打印出来
    private void print(){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
