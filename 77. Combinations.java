   public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList();
        dfs(1, new ArrayList(), result, k, n);        
        return result;
    }    
    
    void dfs(int index, List<Integer> cur, List<List<Integer>> result, int k, int n)
    {        
        if(cur.size() == k)
        {
            result.add(new ArrayList(cur));
            return;
        }
        
        for(int i = index; i <= n ; i++)
        {
            cur.add(i);
            dfs(i + 1, cur, result, k, n);
            cur.remove(cur.size() - 1);
        }        
        
    }