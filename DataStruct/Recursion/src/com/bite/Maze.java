package com.bite;

public class Maze {
    public static void main(String[] args) {
        //西安创建二维数组，模拟迷宫
        int[][] map=new int [8][7];
        //使用1表示墙,
        //上下全部为1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全部为1
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        print(map);

        //使用回溯给小球找路
        System.out.println(setWay2(map,1,1));
        print(map);

    }

    //遍历地图
    public static void print(int[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //使用回溯给小球找路
    /*
    1.说明：map表示地图
    2.i,j表示从呢个位置开始出发（1,1）
    3.如果小球找到map([6][5])的位置说明找到出路‘
    4.约定：当map[i][j]为0表示还没有走过，为1表示为墙，为2表示可以走，为3表示走过，但是走不通
    5.策略：下-》右-》上-》左，走不通就回溯
     */

    /**
     * @param map  地图
     * @param i 从那个位置开始找
     * @param j
     * @return 如果找到返回true，找不到返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){//通路已经找到了
            return true;
        }else {
            if(map[i][j]==0){//如果当前这条路还没有走过
                //策略：下，右，上，左
                map[i][j]=2;//假设该点 可以走通
                if(setWay(map,i+1,j)){//下
                    return true;
                }else if(setWay(map,i,j+1)){//右
                    return true;
                }else if(setWay(map,i-1,j)){//上
                    return true;
                }else if(setWay(map,i,j-1)){//左
                    return true;
                }else {
                    //说明该点走不通
                    map[i][j]=3;
                    return false;
                }
            }else {//如果map[i][j]!=0,肯是1,2,3
            }
            return false;
        }
    }
    //策略：上，右，下，左
    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5]==2){//通路已经找到了
            return true;
        }else {
            if(map[i][j]==0){//如果当前这条路还没有走过
                //策略：下，右，上，左
                map[i][j]=2;//假设该点 可以走通
                if(setWay2(map,i-1,j)){//上
                    return true;
                }else if(setWay2(map,i,j+1)){//右
                    return true;
                }else if(setWay2(map,i+1,j)){//下
                    return true;
                }else if(setWay2(map,i,j-1)){//左
                    return true;
                }else {
                    //说明该点走不通
                    map[i][j]=3;
                    return false;
                }
            }else {//如果map[i][j]!=0,肯是1,2,3
            }
            return false;
        }
    }
}
