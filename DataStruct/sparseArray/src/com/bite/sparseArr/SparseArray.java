package com.bite.sparseArr;
/*
        0：表示没有旗子，
        1：表示黑棋子
        2：表示蓝色旗子
 */
public class SparseArray {
    public static void main(String[] args) {

        //创建一个原始的二维数组：11*11
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;

        //输出原始的二维数组
        System.out.println("原始的二维数组~~~");
        for(int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //遍历二维数组得到sum个数
        int sum=0;
        sum=arr(chessArr1,11,11);

        //创建稀疏数组
        int sparseArr[][]=new int [sum+1][3];

        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        print(sparseArr,1,3);

        //给稀疏数组赋值
        assignment(chessArr1,sparseArr,11,11);
        System.out.println("打印稀疏数组~~");
        print(sparseArr,3,3);

        /*
        稀疏数组---》原始数组
         */

        //1把稀疏数组转为原始的二维数组
        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.在读取稀疏数组后的几行数据（从第二行开始），并赋值给原始的二维数组
        for(int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印原始数组
        print(chessArr2,11,11);

    }
//遍历数组,得出8元素个数
    public static int arr(int arr[][],int row,int col){
        int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]!=0){
                    sum++;
                }
            }
        }
        return sum;
    }
    //打印数组
    public static void print(int arr[][],int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
    }

    //稀疏数组赋值
    public static void assignment(int arr1[][],int arr2[][],int row,int col){
        //count用于记录稀疏数组的个数
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr1[i][j]!=0){
                    count++;
                    arr2[count][0]=i;
                    arr2[count][1]=j;
                    arr2[count][2]=i;

                }
            }
            System.out.println();
        }
    }
}

