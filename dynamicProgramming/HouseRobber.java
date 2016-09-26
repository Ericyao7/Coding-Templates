public class Solution {
    public int rob(int[] nums) {
   /*
    Dynamic programming
    Bottom-up approach
    Since we cannot rob 2 adjacent houses, generally, we cannot rob house[n] and house [n-1] at the same night
    So the basic idea is to see if house[n-1] has been robbed
    If house[n-1] has been robbed, then the optimal approach should be max{robbedmoney(n-1), robbedmoney(n-2)+nums[n]}
    If house[n-1] hasn't been robbed, then the optimal approach should be robbedmoney(n-2)+nums[n]
    */
    
    if(nums.length==0){
        return 0;
    }
    
    if(nums.length==1){
        return nums[0];
    }
    
    int[] maxProfit = new int[nums.length];
    
    maxProfit[0] = nums[0];
    maxProfit[1] = Math.max(nums[1],nums[0]);
    
    
    for(int i=2; i<nums.length;i++){
        maxProfit[i] = Math.max(maxProfit[i-1],maxProfit[i-2]+nums[i]);
    }
    
    return maxProfit[nums.length-1];
    
    }
}





public class Solution {
    public int rob(int[] nums) {
        //The idea is to decide if the thief rob the first house or not
        
        
        if(nums.length==0){
            return 0;
        }
        
        if(nums.length==1){
            return nums[0];
        }
        
        int[] maxProfit = new int [nums.length];
        
        //firstcase
        maxProfit[0] = nums[0];
        maxProfit[1] = Math.max(nums[0],nums[1]);
        
        for(int i = 2; i<nums.length-1;i++){
                maxProfit[i] = Math.max(maxProfit[i-1],maxProfit[i-2]+nums[i]);
        }
        int firstcase = maxProfit[nums.length-2];
        
        //secondcase
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        maxProfit[0] = nums[0];
        maxProfit[1] = nums[1];
        maxProfit[2] = Math.max(nums[1],nums[2]);
        for(int i = 3; i<nums.length;i++){
                maxProfit[i] = Math.max(maxProfit[i-1],maxProfit[i-2]+nums[i]);
        }
        
        int secondcase = maxProfit[nums.length-1];
        
        return Math.max(firstcase,secondcase);
            
    }
}





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
       if(root==null){
           return 0;
       }
       
       //for each node, two cases, rob the root or not
       int val = root.val;
       if(root.left!=null){
           val+=rob(root.left.left)+rob(root.left.right);
       }
       
       if(root.right!=null){
           val+=rob(root.right.left)+rob(root.right.right);
       }
        
        
       return Math.max(val,rob(root.left)+rob(root.right));    
        
        
        
    }
    
}