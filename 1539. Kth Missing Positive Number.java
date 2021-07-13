     public int findKthPositive(int[] nums, int k)
     {
        int n = nums.length - 1;         
        int numMissing = nums[n] - n - 1;
        if(numMissing < k)
        {
            return nums[n] + k - numMissing;
        }
         
        int left = 0, right = n;       
        while (left < right) 
        {
            int mid = left + (right - left) / 2;            
            if (nums[mid] - mid - 1 < k) 
            {
                left = mid + 1;
            }            
            else 
            {
                right = mid;
            }
        }
        
        numMissing = nums[left] - left - 1;
        return nums[left] + k - numMissing - 1;
    }