 public int[] searchRange(int[] nums, int target) 
    {        
        int first = find(nums, target, true);
        int last = find(nums, target, false);        
        
        return new int[] { first, last };
    }
    
    
    int find(int[] nums, int target, boolean first)
    {
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                index = mid;
                if(first) 
                {
                   high = mid - 1  ;
                }
                else
                {
                   low = mid + 1;  
                }
            }
            else if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return index;        
    }