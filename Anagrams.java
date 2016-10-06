public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public ArrayList<String> anagrams(String[] strs) {
     ArrayList<String> result=new ArrayList<String>();
     
     if (strs==null||strs.length==0)
         return result;
     
     HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
     
     for (String s:strs){
         char[] temp=s.toCharArray();
         Arrays.sort(temp);
         String tempStr=new String(temp);
         
         if (hm.containsKey(tempStr)){
             if(hm.get(tempStr).size() == 1)
                result.add(hm.get(tempStr).get(0));
             hm.get(tempStr).add(s);
             result.add(s);
         }else{
             ArrayList<String> tempList=new ArrayList<String>();
             tempList.add(s);
             hm.put(tempStr, tempList);
             }
        }
        return result;
 }
}
