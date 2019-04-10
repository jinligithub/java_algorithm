跳台阶
时间限制：1秒 空间限制：32768K 热度指数：385243

题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）

 //递归的方法
public class Solution {
    public int JumpFloor(int target) {
        if(target==0)//跳0阶，直接返回0
            return 0;
        if(target==1||target==2)//跳一阶或两阶台阶，直接返回对应的阶数
            return target;
        return JumpFloor(target-2)+JumpFloor(target-1);//当台阶数大于2时，跳法就等于跳一阶和跳两阶的和
    }
}
 //利用非递归的方法，第一三个数
public class Solution {
    public int JumpFloor(int target) {
        int num1=1;//第一个台阶的跳法
        int num2=2;//第二个台阶的跳法
        int result=0;
        if(target==1||target==2){
            return target;
        }else{//台阶数超过3的跳法
            for(int i=3;i<=target;i++){
                result=num1+num2;
                num1=num2;
                num2=result;
            }
            return result;
        }
    }
}