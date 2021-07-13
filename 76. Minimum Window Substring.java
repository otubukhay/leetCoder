 public String minWindow(String s, String t) 
    {        
        Map<Character, Integer> needMap = new HashMap();
        for(char cur : t.toCharArray())
        {
           needMap.put(cur, needMap.getOrDefault(cur, 0) + 1);
        }     
        
        int startIndex = -1;
        int len = Integer.MAX_VALUE;
        
        int count = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);            
            if(needMap.containsKey(cur) && map.get(cur) <= needMap.get(cur))
            {
               count++;    
            }
                        
            if(count == t.length())
            {                
                while(start < i && (!needMap.containsKey(s.charAt(start)) || map.get(s.charAt(start)) > needMap.get(s.charAt(start))))
                {
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                    if(map.get(s.charAt(start)) == 0)
                    {
                       map.remove(s.charAt(start));
                    }
                    
                    start++;                    
                }
            
                if(i - start + 1 < len)
                {
                   len = i - start + 1;
                   startIndex = start;
                }
                    
            }
            
        }
        
        if(startIndex == -1)
            return "";
        
        return  s.substring(startIndex, startIndex + len);
    }