÷±Ω”≤Â»Î≈≈–Ú

public static void insertSort(int[] arr){
	for(int i=;i<arr.length;i++){
		for(int j=i+1;j>0;j--){
			if(arr[j-1]<=arr[j])
				break;
			int temp=arr[j];
			arr[j]=arr[j-1];
			arr[j-1]=temp;
		}
	}
}


public static  void insertSort(int[] arr){
	for(int i=0;i<arr.length;i++){
		int temp=arr[i];
		for(int j=i;j>=0;j--){
			if(j>0&&arr[j-1]>arr[j]){
				arr[j]=arr[j-1];
			}else{
				arr[j]=temp;
				break;
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     )
	}
}


