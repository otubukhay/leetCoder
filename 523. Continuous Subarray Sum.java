 public boolean checkSubarraySum(int[] nums, int k) {           
        /*       
        Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + modk_1
        Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + modk_2
        If they have the same mod, which is modk_1 == modk_2, subtracting these two running sum we get the difference sum_i - sum_j = (x - y) * k = constant * k, 
        and the difference is the sum of elements         between index i and j, and the value is a multiple of k.
        */
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];    
            if(k != 0)
            {
               sum = sum % k;    
            }
            
            if(map.containsKey(sum))
            {
                if(i - map.get(sum) > 1)    
                {
                    return true;
                }
            }
            else
            {
                map.put(sum, i);
            }
        }
        
        return false;

    }