 public boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length() > s2.length())
            return false;
       
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        for(int i = 0; i < s1.length(); i++) 
        {
            s1map[s1.charAt(i) - 'a']++;           
        }
        
        int start  = 0;
        int end = 0;
        while(end < s2.length())
        {
            s2map[s2.charAt(end) - 'a']++;
            if(end >= s1.length() - 1)
            {
                if(Arrays.equals(s1map, s2map))
                  return true;
               
                s2map[s2.charAt(start) - 'a']--;
                start++;    
            }
            
            end++;
        }
        
        return false;
    }  