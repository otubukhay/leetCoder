    public int longestValidParentheses(String s) {
       int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        
        for(int i = 1; i < n; i++)
        {
           Character cur =  s.charAt(i);
           if(cur == ')')
           {
               if(s.charAt(i - 1) == '(')
               {
                   dp[i] = (i - 2 >= 0) ? dp[i - 2] + 2 : 2;                   
               }
               else
               {
                   int lengthWithPreviousAsClosing = dp[i - 1];
                   int positionOfMatch = i - lengthWithPreviousAsClosing;
                   if(positionOfMatch > 0 && s.charAt(positionOfMatch - 1) == '(')
                   {
                       int lengthOfRest = positionOfMatch - 2 >= 0 ? dp[positionOfMatch - 2] : 0;
                       dp[i] = dp[i - 1] + lengthOfRest + 2;                       
                   }                   
               }   
               
               max = Math.max(max, dp[i]);
           }           
        
        }
    
        return max;
    }