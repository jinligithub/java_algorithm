概念 ：归并算法是将两个或者两个以上的 有序列表 合并成一个新的有序列表，
即把待排序列分为若干个子序列，每个子序列都是有序的，然后把子序列合并成整体有序列表。
若将两个有序表合并成一个有序表，称为二路归并。

算法思想：归并排序（mergeSort）是利用归并的思想实现的排序方法，
该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)

步骤：

分解：将序列每次折半拆分
合并：将划分后的序列段两两排序合并
算法描述：

将序列每相邻的两个数字进行归并操作，形成n/2个子序列，排序后每个子序列包含两个元素。
再讲子序列的相邻两个序列进行归并，形成n/4个子序列。
直到所有元素排序完毕，排序结束。


方法：递归方法

public class MergeSort {
    //测试
    public static void main(String[] args) {
        int[] arr=new int[] {5,4,3,6,2,8,7,1};
        mergeSort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    //并归排序
    public static int[] mergeSort(int[] arr, int start,int end) {
        if(start<end){
            int mid=(start+end)/2;//划分排序的子序列个数
            mergeSort(arr,start,mid);//对左侧子序列进行排序
            mergeSort(arr,mid+1,end);//对右侧子序列进行排
            merge(arr,start,mid,end);//合并
        }
        return arr;
    }
 
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp=new int[arr.length];
        int p1=left;//p1,p2是检测指针
        int p2=mid+1;
        int k=left;//k是存放指针
        while(p1<=mid&&p2<=right){//把两个合并的子序列里面较小的数放前边，大的数放后边
            if(arr[p1]<=arr[p2]){
                tmp[k++]=arr[p1++];
            }else{
                tmp[k++]=arr[p2++];
            }
        }
        while(p1<=mid)//把没有排完的数直接追加到tmp后边
            tmp[k++]=arr[p1++];
        while(p2<=right)
            tmp[k++]=arr[p2++];
        for(int i=left;i<=right;i++){//把临时数组tmp里的内容赋给arr
            arr[i]=tmp[i];
        }
    }
}


归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。
而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
