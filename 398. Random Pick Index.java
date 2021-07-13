    //O(n)
	Map<Integer, List<Integer>> map = null;
    public Solution(int[] nums) 
    {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],  new ArrayList<>());
            
            map.get(nums[i]).add(i);
        }
    }
    
	//O(1)
    public int pick(int target) 
    {
        int index = new Random().nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
	

**************************************************************************************
Approach 3: Reservoir sampling
*****************************************************************************************
    private int[] nums;
    private Random rand;
    
    public Solution(int[] nums) 
	{
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) 
	{
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) 
		{
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (this.nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0)
				{
                    idx = i;
                }
            }
        }
        return idx;
    }