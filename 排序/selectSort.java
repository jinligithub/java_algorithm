import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] arr=new int[] {98,16,46,56,5,33};
        selectSort2(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort1(int[] arr,int len){
        for(int i=0;i<len-1;i++){//排序的趟数
            int max=0;//记录最大值得下标
            for(int j=1;j<=len-i-1;j++){//比较元素的次数
                if(arr[max]<arr[j]){
                    max=j;
                }
            }
            if(max!=len-i-1){//如果最大的数，没有在对应的位置才进行交换
                int tmp=arr[len-i-1];
                arr[len-i-1]=arr[max];
                arr[max]=tmp;
            }
        }
    }
    //优化双向排序
    public static void selectSort2(int[] arr,int len){
        for(int i=0;i<len/2;i++){//排序的趟数
            int max=i;//记录最大值得下标
            int min=i;
            for(int j=1+i;j<len-i-1;j++){//比较元素的次数，左边+，右边-
                if(arr[max]<arr[j]){
                    max=j;
                }
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(arr[max]!=arr[len-i-1]){//如果最大的数，没有在对应的位置才进行交换
                int tmp=arr[len-i-1];
                arr[len-i-1]=arr[max];
                arr[max]=tmp;
            }
            if(arr[min]!=arr[i]){
                int tmp=arr[i];
                arr[i]=arr[min];
                arr[min]=tmp;
            }
        }
    }
}
