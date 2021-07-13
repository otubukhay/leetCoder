 HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
         return wordBreak(s, new HashSet<String>(wordDict));
    }
    
    
    public List<String> wordBreak(String s, Set<String> wordDict) 
    {
        List<String> res = new ArrayList<String>();        
        if(s == null || s.length() == 0) 
        {
            return res;
        }
        
        if(map.containsKey(s)) 
        {
            return map.get(s);
        }
        
        if(wordDict.contains(s)) 
        {
            res.add(s);
        }
        
        for(int i = 1 ; i < s.length(); i++) 
        {
            String t = s.substring(0, i);
            if(wordDict.contains(t)) 
            {               
                for(String str : wordBreak(s.substring(i), wordDict)) 
                {
                    res.add(t + " " + str);
                }
            }
        }
        
        map.put(s , res);
        return res;
    }