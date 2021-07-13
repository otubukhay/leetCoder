 //O(4 ^ n)
 public List<String> generateParenthesis(int n) 
    {
        List<String> result = new ArrayList<>();
        printAll(result, "", 0, 0, n);
        return result;
    }
    
    
    void printAll(List<String> result, 
                  String current, int open, int closed, int n)
    {
        if(closed >= n)
        {
            result.add(current);
            return;
        }
        
        if(open < n)
        {
            printAll(result, current + "(", open + 1, closed, n);
        }
        
        if(closed < open)
        {
           printAll(result, current + ")", open, closed + 1, n);
        }
    }
	
	//With String Builder
	
	public List<String> generateParenthesis(int n) 
    {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max)
    {
        if(close >= max)
        {
            ans.add(cur.toString());
            return;
        }

        if (open < max) 
        {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        
        if (close < open) 
        {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }