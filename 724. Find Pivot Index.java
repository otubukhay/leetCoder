 public int pivotIndex(int[] nums) 
    {
        int sum = 0, leftsum = 0;
        for (int x: nums) 
        {
            sum += x;
        }
        
        for (int i = 0; i < nums.length; ++i) 
        {
            if(2 * leftsum + nums[i] == sum)
            {
                 return i;
            }
               
            leftsum += nums[i];
        }
        
        return -1;
    }