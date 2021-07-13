 public int lengthOfLongestSubstring(String s)
 {
        if(s.length() == 0)
            return 0;
        
        int start = 0, end  = 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        while(end < s.length())
        {
            char c = s.charAt(end);          
            if(map.containsKey(c))
            {
                start = Math.max(start, map.get(c) + 1);  
            }
            
            map.put(c, end);
            len = Math.max(len, end - start + 1);
            end++;
        }
        
        return len;
    }