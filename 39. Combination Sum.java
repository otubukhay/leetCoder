public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList(); 
        dfs(0, candidates, target, new ArrayList(), result);
        return result;
    }
    
     private void dfs(int index, int[] candidates, int target, 
                         List<Integer> curList, List<List<Integer>> result) 
     {
        if(target == 0)
        {
            result.add(new ArrayList<>(curList));
            return;
        }
        
        if(target < 0)
            return;
        
        for(int i = index; i < candidates.length; i++) 
        {          
            curList.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], curList, result);
            curList.remove(curList.size() - 1);    
        }
     }