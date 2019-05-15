删数

有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。




import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            deleteTwoNum(n);
        }
    }
public static void deleteTwoNum(int n){
        int index = 0;//保存元素下标
        int[] a = new int[n];//标记数组中的元素是否已经被删除过     
        int flag = 0;//记录间隔的元素个数，当inteval=3时候更新删除标记为flag
        int count_delete = 0;//统计删除的元素个数
        //总共删除n个元素
        while(count_delete < n){
        //当i=n时候，相当于从0继续循环遍历
            for(int i = 0 ; i != n ; i++){
            //当前数组元素i还没有被删除
                if(a[i] == 0){
                flag++;
                if(flag == 3){
                    a[i] = 1;//更新删除标记位
                    flag = 0;//更新间隔元素个数
                    index = i;//保存删除元素的下标
                    count_delete++;
                 }
              }
            }//endfor
         }
       System.out.println(index);
     }
}