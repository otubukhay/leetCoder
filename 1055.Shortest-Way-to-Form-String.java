    public int shortestWay(String source, String target)
    {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        boolean[] map = new boolean[26];
        for (int i = 0; i < cs.length; i++) 
            map[cs[i] - 'a'] = true;
        
		int j = 0, subsequences = 1;
        int i = 0;
        while(i < ts.length) 
        {
            if (!map[ts[i] - 'a']) 
                return -1;
            
			while (j < cs.length && cs[j] != ts[i]) 
            {
                j++;
            }
            
            if(j == cs.length) 
            {
                j = 0;               
                subsequences++;                
            }
            else
            {
                j++;
                i++;
            }
        }
	    return subsequences;
    }
	
****************************************************************************************************************
    static int shortestWay(String source, String target)
	{
        if(source.equals(target))
          return 1;
        
        int lo = 1, hi = target.length();
        int count = -1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(canForm(source, target, mid))
            {
                count = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return count;
    }
	
	static boolean canForm(String source, String target, int len)
    { 
        int srcLen = source.length();
        int totalLen = len * srcLen;
        if(totalLen < target.length())
           return false;
        
        int sIndex = 0;
        int targetIndex = 0;
        while(sIndex < totalLen)
        {
            if(source.charAt(sIndex % srcLen) == target.charAt(targetIndex))
            {
               if(targetIndex == target.length() - 1)    
                   return true;
               
               targetIndex++;
            }
            
            sIndex++;
        }
        
        return false;     
    }
    
    