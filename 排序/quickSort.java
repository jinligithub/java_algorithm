import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr=new int[] {98,16,46,56,5,33};
        quickSortInternal2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr){
            int n=arr.length;
            if(n<=1)
                return ;
            quickSortInternal(arr,0,n-1);
        }
        //递归写法
        public static void quickSortInternal(int[] arr,int left,int right){
            if(left>=right)//结束条件
                return;
            int q=partion1(arr,left,right);//基准值
            quickSortInternal(arr,left,q-1);//递归左边的数组
            quickSortInternal(arr,q+1,right);//递归右边的数组

        }
    //随机选取一个元素作为基准值，来降低每次都选到最小或最大值的概率
    public static int partion1(int[] arr,int left,int right){
        //返回下标l...r的任意一个数
        /**
         * Math.random()：产生0~1之间的任意一个小数
         * right-left+1:数组长度
         * +left:保证从left开始
         */
        int randomIndex=(int)((Math.random())*(right-left+1)+left);
        swap(arr,left,randomIndex);//交换当前元素和基准值
        int v=arr[left];//基准值
        //arr[left+1...j]<V
        int j=left;
        //arr[j+1...i-1]>V
        int i=left+1;
        for(;i<=right;i++){
            if(arr[i]<v){
                swap(arr,j+1,i);
                j++;
            }
        }
        //交换left和j元素
        swap(arr,left,j);
        return j;

    }

    private static void swap(int[] arr, int A, int B) {
        int tmp=arr[A];
        arr[A]=arr[B];
        arr[B]=tmp;

    }
    //优化二：解决大量重复元素导致基准值两边的数组长度不均衡问题
    public static int partion2(int[] arr,int left,int right){
        //产生一个在数组范围内的随机数，做基准值
        int randomIndex=(int)(Math.random()*(right-left+1))+left;
        //把左边元素和产生的随机数交换
        swap(arr,left,randomIndex);
        //基准值
        int v=arr[left];
        //arr[left+1...i-1]
        int i=left+1;//左边索引
        //arr[j+1...right]
        int j=right;//右边索引
        while(true){
            //从前向后扫描找比基准值大的数
            while(i<=right&&arr[i]<v)   i++;
            //从前向后扫描找比基准值小
            //
            // 的数
            while(j>=left+1&&arr[j]>v)  j--;
            if(i>j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,left,j);
        return j;
    }
    public static void partion3(int[] arr,int left,int right){
        int n=arr.length;
        if(n<=1)
            return ;
        quickSortInternal2(arr,0,n-1);
    }

    private static void quickSortInternal2(int[] arr, int left, int right) {
        if(left>=right)//终止条件
            return;
        //产生一个随机的基准值，减少取最小的值做基准值的机会
        int randomIndex=(int)((Math.random()*(right-left+1))+left);
        //把当前的值和基准值交换
        swap(arr,left,randomIndex);
        //定义基准值
        int v=arr[left];

        //arr[left+1...leftT]<v   小于V的数
        int lt=left;
        //arr[gt....r]>v  大于V的数
        int gt=right+1;
        //从下一个位置开始扫描
        int i=left+1;
        while(i<gt){
            if(arr[i]<v){
                swap(arr,lt+1,i);
                lt++;
                i++;
            }else if(arr[i]>v){
                swap(arr,gt-1,i);
                gt--;
            }else {
                i++;
            }
        }
        swap(arr,left,lt);
        //这里只用递归大于和小于基准值的数，等于的不用管
        quickSortInternal2(arr,left,lt-1);
        quickSortInternal2(arr,gt,right);
    }
}
