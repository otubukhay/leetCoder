    public List<List<Integer>> subsetsWithDup(int[] nums) 
	{
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<Integer>());
        return res; 
    }
    
    List<List<Integer>> res = new ArrayList<>();       
    private void helper(int index, int[] nums, List<Integer> list) 
    {
        res.add(new ArrayList<>(list));         
        for(int i = index; i < nums.length; i++)
        {     
            if(i > index && nums[i] == nums[i - 1])
                continue;
            
            list.add(nums[i]);
            helper(i + 1, nums, list);
            list.remove(list.size() - 1);
        }       
    }