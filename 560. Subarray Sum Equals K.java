public int subarraySum(int[] nums, int k)
    {
        Map<Integer,Integer> m = new HashMap();        
        m.put(0, 1); //only empty string
        int count = 0;
        int sum = 0;
        
        for(int num : nums)
        {
          sum +=num;      
          count += m.getOrDefault(sum - k, 0);
          m.put(sum, m.getOrDefault(sum, 0) + 1);
        }

        return count;
    }