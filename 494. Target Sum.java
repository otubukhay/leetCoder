
    //Time complexity: O(ln). The memo array of size l*n has been filled just once. Here, l refers to the range of sumsum and nn refers to the size of nums array.
    //Space complexity: O(ln). The depth of recursion tree can go upto nn. The memo array contains n elements./    
    public int findTargetSumWays(int[] nums, int S) 
    {
        Map<String, Integer> map =  new HashMap<>();
        return process(0, nums, 0,  S, map);        
    }    
    
    private int process(int index, int[] nums, int curSum, int targetSum, Map<String, Integer> map)
    {      
        String key = index + "=>" + curSum;
        if(map.containsKey(key))
            return map.get(key);
        
        if(index >= nums.length)
        {
            return (curSum == targetSum) ? 1 : 0;              
        }          
            
        int minus = process(index + 1, nums, curSum - nums[index], targetSum , map);
        int plus = process(index + 1, nums, curSum + nums[index], targetSum , map);
        
        map.put(key, plus + minus);
        return map.get(key);
    }