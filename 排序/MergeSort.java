public class MergeSort {
    //测试
    public static void main(String[] args) {
        int[] arr=new int[] {5,4,3,6,2,8,7,1};
        mergeSort1(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    //并归排序
    public static int[] mergeSort1(int[] arr, int start,int end) {
        if(start<end){
            int mid=(start+end)/2;//划分排序的子序列个数
            mergeSort1(arr,start,mid);//对左侧子序列进行排序
            mergeSort1(arr,mid+1,end);//对右侧子序列进行排
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
    public static void mergeSort2(int[] array,int low,int high) {
        // 优化一：数据比较少时，采用直接 插入排序
        if (high - low <= 15) {
            InsertSort.insertSort1(array,array.length);
            return;
        }
        int mid = (low + high) / 2;
        // 左边小数组
        mergeSort2(array,low,mid);
        // 右边小数组
        mergeSort2(array,mid+1,high);
        // 合并    ---->优化二：当左边元素的最大值比右边元素的最小值都小时，说明整个数组有序，直接借宿排序
        if (array[mid] >= array[mid+1]) {
            merge(array,low,mid,high);
        }
    }
    private static void merge2(int[] array,int p,int q,int r) {
        int i = p;
        int j = q + 1;
        int[] temp = new int[r-p+1];
        int k = 0;
        // 此时两个数组中均有元素
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                // 第一个数组中的相同位置元素最小
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }
        // 判断当前还有哪个数组元素没有走完
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 把剩余元素直接放置在temp数组后即可
        while (start <= end) {
            temp[k++] = array[start++];
        }
        // 将临时空间中已经合并好的元素拷贝回原数组
        for (i = 0;i < r-p+1;i++) {
            array[p+i] = temp[i];
        }
    }
}
