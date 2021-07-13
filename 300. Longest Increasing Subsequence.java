    int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        int max = 1;
        
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {                
                if(nums[j] > nums[i] && dp[i] + 1 > dp[j])
                {
                    dp[j] = dp[i] + 1;
                }
                
                max = Math.max(max, dp[j]);                
            }            
        }
        
        return max;        
    }
 
 ******************************************************************************************************
    int findWithBinarySearch(int[] nums)
    {
        int len = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[len - 1])
            {
                nums[len] = nums[i];
                len++;
            }
            else if(nums[i] < nums[0])
            {
                nums[0] = nums[i];
            }
            else
            { 
                int index = findIndex(0, len - 1, nums, nums[i]);
                nums[index] = nums[i];
            }            
            
        }
        
        return len;        
    }
    
    
    int findIndex(int lo, int hi, int[] nums, int target)
    {
        int index = -1;
        while(lo <= hi)
        {
           int mid = lo + (hi - lo)/2;
           if(nums[mid] < target)
           {
               lo = mid + 1;
           }
           else
           {
               index = mid;
               hi = mid - 1;               
           }            
            
        }
        
        return index;
    }