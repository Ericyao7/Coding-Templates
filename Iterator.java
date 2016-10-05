public String count(String s, int k){
    int[] count = new int[26];
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        count[c-'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<count.length; i++){
        if(count[i] >0 && count[i] <k)
            sb.append((char)(i+'a'));
    }
    return sb.toString();
}



Iterator entries = m.entrySet().iterator();

        while (entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            Integer value = (Integer) entry.getValue();

            if(value>1){
                res++;
            }

        }
