    public boolean increasingTriplet(int[] nums) 
    {        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int n : nums) 
        {
            if (n <= smallest) 
            { 
                smallest = n; 
            }
            else if (n <= secondSmallest) 
            { 
                secondSmallest = n; 
            }
            else 
            {
                return true;
            }
        }
        
        return false;
    }
	
*****************************************************************************************************
	
	public boolean increasingTriplet(int[] nums) 
    {
        if(nums.length <= 2)
            return false;        
        
        int n = nums.length;
        int[] highs = new int[n];
        highs[n - 1] = nums[n - 1];
        
        for(int i = nums.length - 2; i >= 0; i--)
        {
            highs[i] = Math.max(nums[i], highs[i + 1]);
        }
        
        int smallest = nums[0];        
        for(int i = 1; i < nums.length - 1; i++)
        {
            if(nums[i] > smallest && highs[i + 1] > nums[i])    
                return true;
            
            smallest = Math.min(smallest, nums[i]);
        }
        
        return false;
    }