/*
	利用递归与分治思想将数据序列划分成越来越小的半子表，再对半子表排序，最后用递归将排好序的半子表合并成
	越来越大的有序序列；˜
	对于给定的一组纪录n，首先将每两个相邻长度为1的子序列进行归并，得到n/2（向上取整）个长度为2或1的有序子序列，
	再将两两归并，反复执行此过程之都得到一个有序序列。
*/

public class MergeSort{

	private static void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        merge(A, start, mid, end, temp);
    }
    
    private static void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = start;
        
        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }




	public static void main(String[] args) {
		int i = 0;
		int a[] = {5,4,6,9,2,3,0,4,1,8,7};
		int len = a.length;
		int temp[] = new int[len];

		mergeSort(a,0,len-1,temp);

		for(i=0;i<len;i++){
			System.out.println(a[i]+" ");
		}
	}
}