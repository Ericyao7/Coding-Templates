//Used to implement Subset combination and 


public class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subsetsHelper(res,list,nums,0);
        return res;
        
    }
    
    
    
    public void subsetsHelper(List<List<Integer>> res, List<Integer> list,
    						  int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i<nums.length;i++){
            list.add(nums[i]);
            subsetsHelper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}


/*
Deal with duplicate:
    1.       if(i>0 && candidates[i] == candidates[i-1])//deal with dupicate
                 continue; 

    2.       if(!res.contains(item)) 
                res.add(new ArrayList<Integer>(item));

Allow repeat number:
      input cur index but not index+1
*/
public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(candidates == null || candidates.length==0)  
            return res; 
            
        Arrays.sort(candidates);  
        helper(candidates,target, 0, item ,res);  
        return res;  
    }  
    
    private void helper(int[] candidates, int target, int start, ArrayList<Integer> item,   
    ArrayList<ArrayList<Integer>> res){  
        if(target<0)  
            return;  
        if(target==0){  
            res.add(new ArrayList<Integer>(item));  
            return;  
        }
        
        for(int i=start;i<candidates.length;i++){  
            if(i>0 && candidates[i] == candidates[i-1])//deal with dupicate
                continue;  
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(candidates,newtarget,i,item,res);//之所以不传i+1的原因是：
                                                    //The same repeated number may be 
                                                    //chosen from C unlimited number of times.
            item.remove(item.size()-1);  
        }  
    }