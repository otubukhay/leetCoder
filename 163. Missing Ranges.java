public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        if (nums.length == 0)
		{
            result.add(getRange(lower, upper)); //nums is empty
            return result;
        }
		
        if (nums[0] > lower) 
		{
            result.add(getRange(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) 
		{
            if (nums[i + 1] - nums[i] > 1) 
			{
                result.add(getRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }
		
        if (nums[nums.length - 1] < upper)
		{
            result.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    String getRange(int lo, int hi) 
    {
        return (lo == hi) ? String.valueOf(lo) : String.valueOf(lo) + "->" + String.valueOf(hi);
    }
