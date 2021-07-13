public int maxProduct(int[] nums) 
    {
        if(nums.length == 0)
            return -1;
        
        int min = nums[0];
        int max = nums[0];        
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < 0)    
            {
                int temp = min;
                min = max;
                max = temp;
            }
            
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            
            result = Math.max(result, max);
        }
        
        return result;
    }