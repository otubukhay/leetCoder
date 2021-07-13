public boolean isSubsequence(String s, String t) 
    {
        if (s.length() == 0) 
            return true;        
        
        int indexS = 0;
        for(int indexT = 0; indexT < t.length(); indexT++) 
        {
            if (t.charAt(indexT) == s.charAt(indexS)) 
            {
                if (indexS == s.length() - 1) 
                    return true;
                
                indexS++;
            } 
        }
        
        return false;
    }
    
   ------------------------------------------------------------------------------
   
    boolean dpSolution(String s, String t)
    {        
        if(s.length() > t.length())
           return false;
        
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[0][0] = true;
        
        for(int i = 1; i < s.length(); i++)
        {            
            for(int j = 1; j < t.length(); j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                {
                    dp[i][j] =  dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }