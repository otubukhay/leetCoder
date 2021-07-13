 public int jump(int[] nums) 
    {
        int endOfLadder = 0;
        int maxPossibleLadder = 0;
        
        int jumps = 0;
        for(int index = 0; index < nums.length; index++)
        {
            maxPossibleLadder = Math.max(maxPossibleLadder, index + nums[index]);
            if(index == endOfLadder)    
            {
                jumps++;
                endOfLadder = maxPossibleLadder;
            }
        }
        
        return jumps;
    }
	
	----------------
	
	 int jumpWithDP(int[] nums)
    {
        int[] count = new int[nums.length];
        Arrays.fill(count, nums.length + 1);
        count[0] = 0;
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)    
            {
                if(j + nums[j] >= i)    
                {
                   count[i] = Math.min(count[i], 1 + count[j]);
                }
            }
        }
        
        return count[nums.length - 1];
    }