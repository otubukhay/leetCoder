 public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findAll(0, 0, new ArrayList<>(), result, target, candidates);
        return result;
    }
    
    
    void findAll(int index, int sum, List<Integer> current, List<List<Integer>> result, int target, int[]  nums)
    {        
        if(sum == target)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if(index >= nums.length || sum > target)
            return;
        
        for(int i = index; i < nums.length; i++)
        {
            if(i > index && nums[i] ==  nums[i - 1])
                continue;
            
            current.add(nums[i]);
            findAll(i + 1, sum + nums[i], current, result, target, nums);
            current.remove(current.size() - 1);
        }
        
    }