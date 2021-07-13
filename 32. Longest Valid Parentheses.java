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
	
-----------------------------------------------------------------------------------------------------
    int longestValidParenthesesWithStack(String s)
    {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(') 
            {
                stack.push(i); 
            }
            else
            {                
                stack.pop();
                if(stack.isEmpty()) 
                {
                    stack.push(i);
                }
                else
                {
                    max = Math.max(max, i - stack.peek());
                }
            }        
        }
        
        return max;
    }