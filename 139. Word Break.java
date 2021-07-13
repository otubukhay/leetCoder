public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n = s.length();
        Set<String> set = new HashSet();
        set.addAll(wordDict);
       
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int endIndex = 1; endIndex <= n; endIndex++)
        {
            for(int startIndex = 0; startIndex < endIndex; startIndex++)    
            {
                if(dp[startIndex] && set.contains(s.substring(startIndex, endIndex)))    
                {
                    dp[endIndex] = true;
                }
            }
        }
        
        return dp[n];
    }