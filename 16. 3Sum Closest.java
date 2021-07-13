public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) 
        {         
             int lo = i + 1, hi = nums.length-1;
             while (lo < hi) 
             {
                    int sum = nums[lo] + nums[hi] + nums[i];
                    int newDiff = Math.abs(sum - target);
                    if (newDiff < diff) 
                    {
                        res = sum;    
                        diff = newDiff;
                    }                  
                   
                    if(sum < target)
                    { 
                       lo++;
                    }
                    else 
                    {
                        hi--;
                    }
             }
        }
        return res;
     }