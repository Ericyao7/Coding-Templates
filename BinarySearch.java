/*
	使用start+1<end 就可以避免在mid+1 还是 -1出错 全部写成mid就可以了
*/

public class Solution{
	public int binarySearch(int[] nums, int target){
		if(nums.length==0){
			return -1;
		}
		int start = 0;
		int end = nums.length-1;
		int mid;

		while(start+1 < end){
			mid = start + (end-start)/2;
			if(nums[mid]=target){
				return mid;
			}else if(nums[mid]<target){
				start = mid;
			}else if(nums[mid]>target){
				end = mid;
			}
		}

		if(nums[start] == target){
			return start;
		}

		if(nums[end] == target){
			return end;
		}

		return -1;
	}
}