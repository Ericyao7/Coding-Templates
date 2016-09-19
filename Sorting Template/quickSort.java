/*
这个方法是把所有小于基准的数放在right的左边
所有大于等于的放在left的右边
可以在最后加一步交换 但是没有必要
*/

public class quickSort{
	private static void Sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        

        int left = start, right = end;
        
        int mid = start + (end-start)/2;
        int pivot = A[mid];
        
        //int pivot = A[start];  works well
        
        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (A[left] < pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }
        



        //pay attention in here
        Sort(A, start, right);
        Sort(A, left, end);
    }

    public static void main(String[] args) {
		int i = 0;
		int a[] = {9,2,4,7,3,7,10};
		int len = a.length;
		Sort(a,0,len-1);

		for(i = 0;i<len;i++){
			System.out.println(a[i]+" ");
		}
	}
}