public class TestSort{
	
	//Select Sort
	//对于给定的一组纪录，经过第一次比较得到最小的记录，然后将该记录与第一个记录的位置进行交换；
	//接着对不包括第一个记录外的其它记录进行第二次比较；以此类推
	private static void selectSort(int[] a){
		int index = 0;
		int tmp = 0;
		for(int i = 0;i<a.length;i++){
			int min = a[i];
			index = i;
			for(int j = i+1; j<a.length;j++){
				if(min>a[j]){
					index = j;
					min = a[j];
				}
			}
			tmp = a[i];
			a[i] = min;
			a[index] = tmp;
		}

	}


	//insertSort
	/*
		对于给定的一组记录，假设第一个记录自成一个有序序列，其余为无序序列。
		从第一个记录开始，按照记录大小一次将当前处理的记录插入到其之前的有序序列中

	*/
	private static void insertSort(int[] a){
		int tmp = 0;
		int i = 0;
		int j = 0;
		for(i=0;i<a.length;i++){
			for(j = 0;j<i;j++){
				if(a[i]<a[j]){
					tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
	}


	//Bubble Sort
	/*
		对于n个记录，从第一个记录开始依次对相邻两个记录进行比较，当前面记录大于
		后面记录时，交换位置。最大的数会依次沉入底部
	*/
	private static void bubbleSort(int[] a){
		int tmp = 0;
		int len = a.length-1;

		for(int j = 0; j<len;j++){
			for(int i = 0; i<len-j;i++){
				if(a[i]>a[i+1]){
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1]=tmp;
				}
			}
		}

	}



	public static void main(String[] args) {
		int b = 0;
		int a[] = {13,7,88,3,89,34,434,6,1};
		//int a[] = {5,4,9,8,7,6,0,1,3,2};	//selectSort(a);
		//insertSort(a);
		bubbleSort(a);

		for(b=0;b<a.length;b++){
			System.out.println(a[b]+" ");
		}
	}


}