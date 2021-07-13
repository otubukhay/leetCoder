    // O(N ^ 2 + 2 ^ N + W)
	Map<String, List<String>> map = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        return wordBreak(s, new HashSet<String>(wordDict));
    }    
    
    public List<String> wordBreak(String str, Set<String> wordDict) 
    {
        List<String> res = new ArrayList<String>();  
        if(map.containsKey(str)) 
        {
            return map.get(str);
        }
        
        if(wordDict.contains(str)) 
        {
            res.add(str);
        }
        
        for(int i = 1; i <= str.length(); i++) 
        {
            String firstPart = str.substring(0, i);
            if(wordDict.contains(firstPart)) 
            {               
                for(String secondPart : wordBreak(str.substring(i), wordDict)) 
                {
                    res.add(firstPart + " " + secondPart);
                }
            }
        }
        
        map.put(str, res);
        return res;
    }