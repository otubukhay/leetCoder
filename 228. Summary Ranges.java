 public List<String> summaryRanges(int[] nums) 
    {
        List<String> result = new ArrayList();
        if(nums.length == 0)
            return result;        
        
        int index = 0;                
        while(index < nums.length)
        {
            int start = index;            
            while(index + 1 < nums.length && nums[index] + 1 == nums[index + 1])
            {
               index++;
            }
            
            String range = getRange(nums[start], nums[index]);           
            result.add(range);                
            index++;
        }
        
        return result;
    }    
    
    String getRange(int start, int end)
    {
        if(start == end)
            return String.valueOf(start);
        
        return String.valueOf(start) + "->" + String.valueOf(end);
    }