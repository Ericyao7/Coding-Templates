//Used to implement Subset combination and permutation


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



//Permutation
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
         if (nums == null) {
             return rst; 
         }
         
         if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
         }

         ArrayList<Integer> list = new ArrayList<Integer>();
         //把［］开头的所有排列加入到rst
         helper(rst, list, nums);
         return rst;
    }
    

    //把list 开头的所有排列加入到rest里面
    public void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        //出口
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        //把［1］，［2］，［3］开头的分别加入rst
        for(int i = 0; i < nums.length; i++){
            //这句话很关键
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);  //把1加入到了［］， 变成了［1］开头，
            //把［1］开头的加入rst，已经完成了
            helper(rst, list, nums);
            //因为现在是［1］开头，要［2］开头的话，就要
            //答案里面result已经有［1，2，3］ ［1，3，2］   list=>[1]
            list.remove(list.size() - 1);
        }
        
    }
}



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildingSubsequences {

	public static String[] buildSubsequences(String s){
		
		if(s == null){
			return null;
		}
		
		if(s.length() == 0){
			return new String[0];
		}
		
		List<String> rst = new ArrayList<String>();
		helper(s, rst, new String(), 0);
		
		String[] result = new String[rst.size() - 1];
		Collections.sort(rst);
		
		for(int i = 1; i < rst.size(); i++){
			result[i - 1] = rst.get(i);
		}
		
		return result;
		
	}
	
	private static void helper(String s, List<String> rst, String sub, int start){
		rst.add(new String(sub));
		
		for(int i = start; i < s.length(); i++){
			
			if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
				continue;
			}
			sub += s.charAt(i);
			helper(s, rst, sub, i + 1);
			sub = sub.substring(0, sub.length() - 1);
		}
	}
	
	
}
