 //O(2 ^ n) * n
     public List<String> removeInvalidParentheses(String s) 
 
     {
         List<String> res = new ArrayList<>();
         if (s == null || s.length() == 0) 
         {
            res.add("");  
            return res;             
         }  
 
        Set<String> visit  =  new HashSet<>();
        Queue<String> q = new LinkedList<>(); 
        String temp;        
        q.add(s); 
        visit.add(s);        
        boolean solved = false;
        while (!q.isEmpty()) 
        { 
           int size  = q.size();
           for(int j = 1; j <= size; j++)
           {
                String str = q.remove(); 
                if(isValidString(str)) 
                { 
                    res.add(str);
                    solved = true;
                } 

                if(!solved)
                {
                    for (int i = 0; i < str.length(); i++) 
                    { 
				       char c = str.charAt(i);
                       if (c == '(') || c == ')') 
                       { 
                           temp = str.substring(0, i) + str.substring(i + 1); 
                           if (!visit.contains(temp)) 
                           { 
                             q.add(temp); 
                             visit.add(temp); 
                           } 
                       }
                    } 
                }
               
           }
        } 
    
        return res;
    }
      
    
    boolean isValidString(String str) 
    { 
        int cnt = 0; 
        for (int i = 0; i < str.length(); i++) 
        { 
            if (str.charAt(i) == '(') 
                cnt++; 
            else if (str.charAt(i) == ')') 
                cnt--; 
            
            if (cnt < 0) 
                return false; 
        } 
        return (cnt == 0); 
    } 

 //O(2 ^ n) 
-----------------------------------------------------------------
	public List<String> removeInvalidParentheses(String s) 
	{
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, res, new char[]{'(', ')'});
        return res;
    }

    private void helper(String s, int left, int right, List<String> res, char[] pars)
	{
        int stack = 0;
        int n = s.length();
        for (; right < n; right++)
        {
            char c = s.charAt(right);
            if (c == pars[0]) 
            {
                stack++;
            } 
            else if (c == pars[1]) 
            {
                stack--;
            }

            if (stack < 0) 
            {
                break;
            }
        }

        if (stack < 0) 
        {
            for (; left <= right; left++) 
            {
                char c = s.charAt(left);
                if (c != pars[1]) {
                    continue;
                }
                if (left > 1 && s.charAt(left) == s.charAt(left - 1)) {
                    continue;
                }
                helper(s.substring(0, left) + s.substring(left + 1), left, right, res, pars);
            }
        } 
        else if (stack > 0) 
        {
            helper(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[]{')', '('});
        } 
        else 
        {
            res.add(pars[0] == '(' ? s : new StringBuilder(s).reverse().toString());
        }
    }