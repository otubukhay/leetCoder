 public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();       
        helper(1, new ArrayList<>(), res, n, k);
        return res;
    }
    
    
   
    private void helper(int index, List<Integer> list, List<List<Integer>> res, int target, int k) 
    {
       if(target == 0 && list.size() == k)
       {
            res.add(new ArrayList(list));
            return ;           
       }
        
       if(target <= 0)
       {
           return;
       }
        
       for(int i = index; i <= 9 ; i++)
       {
           list.add(i);
           helper(i + 1, list, res, target -  i, k);
           list.remove(list.size() - 1);
       }
    }