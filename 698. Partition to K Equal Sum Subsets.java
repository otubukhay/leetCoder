public boolean canPartitionKSubsets(int[] nums, int k) 
    {
        int sum = 0;        
        for(int num : nums)
            sum += num;
        
        if((sum % k) != 0)
            return false;
        
        return find(nums, 0, new boolean[nums.length], 0, k, sum/k, 0);
    }
    
    boolean find(int[] nums, int curSum, boolean[] visited, int bucket, int k, int expectedSum, int index)
    {
        if(bucket == k - 1 && curSum == expectedSum)
        { 
            return true;
        }  
        
        if(curSum > expectedSum)
		{
            return false;
		}
        
        if(curSum == expectedSum)
        {
           return find(nums, 0, visited, bucket + 1, k, expectedSum, 0);    
        } 
        else
        {
            for(int i = index; i < nums.length; i++)
            {            
                if(!visited[i])
                {
                   visited[i] = true;                    
                   if(find(nums, curSum + nums[i], visited, bucket, k, expectedSum, i + 1))
                   {
                      return true;    
                   }
                   visited[i] = false;
                }
            }     
            
            return false;
        }     
        
        
    }