import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[] {98,56,46,56,5,33,89,47,1,23,45};
        bubbleSort4(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
//普通方法：用两层循环，外层决定排序的趟数，内层决定每层里面比较的次数，
//然后如果前一个数比后一个数大，就进行交换
    public static void bubbleSort(int[] arr,int len) {
        for(int i=0;i<len-1;i++){//外部循环
            for(int j=0;j<len-i-1;j++){//内部循环
                if(arr[j]>arr[j+1]) {//如果前一个数比后一个数大的话就进行交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
	//优化方法1：添加标记flag，来判断有没有进行交换，如果一趟下来都没有进行交换，那么说明元素都已经有序了，
	//就不需要进行排序了。它减少了多余的排序次数
    public static void bubbleSort2(int[] arr,int len) {
        for(int i=0;i<len-1;i++){//外部循环
            int flag=0;//添加的标记
            for(int j=0;j<len-i-1;j++){//内部循环
                if(arr[j]>arr[j+1]) {//如果前一个数比后一个数大的话就进行交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                    flag=1;//如果交换了，就把标记修改为1
                }
            }
            if(flag==0){//如果没有进行交换，就说明排序已经完成
                break;
            }
        }
    }
	//优化方法二：记录交换的位置，如果交换位置为0的时候就说明排序完成
    public static void bubbleSort3(int[] arr,int len) {
        for(int i=0;i<len-1;i++){//外部循环
            int pos=0;//记录最开始的交换位置
            for(int j=0;j<len-i-1;j++){//内部循环
                if(arr[j]>arr[j+1]) {//如果前一个数比后一个数大的话就进行交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                    pos=j;//如果交换了，就把交换位置修改为j
                }
            }
            if(pos==0){//如果pos==0，就说明排序已经完成
                break;
            }
        }
    }
	
	//优化方案四：每一趟不仅可以把最大的数冒泡泡到最后相应的位置，
	//也可以把最大的数冒泡泡到前边对应的位置，也就是同时排序，
	//它是减少了排序的趟数
	//
    public static void bubbleSort4(int[] arr,int len) {
        for(int i=0;i<len-1;i++){//外部循环
            int flag=0;//添加的标记
            for(int j=0;j<len-i-1;j++){//内部循环
                if(arr[j]>arr[j+1]) {//如果前一个数比后一个数大的话就进行交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                    flag=1;//如果交换了，就把标记修改为1
                }

            }
            for(int z=0;z<len-i-1;z++){
                if(arr[z+1]<arr[z]) {//如果后一个数比前一个数小的话就进行交换
                    int tmp = arr[z];
                    arr[z] = arr[z + 1];
                    arr[z+1]=tmp;
                    flag=1;//如果交换了，就把标记修改为1
                }
            }
            if(flag==0){//如果flag==0，就说明排序已经完成
                break;
            }
        }
    }
}

