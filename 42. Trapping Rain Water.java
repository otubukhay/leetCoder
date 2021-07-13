 public int trap(int[] heights) 
    {        
        if(heights.length <= 2)
            return 0;
        
        int left = 0;
        int right = heights.length - 1;
        
        int result = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while(left < right)
        {
            maxLeft = Math.max(maxLeft, heights[left]);
            maxRight = Math.max(maxRight, heights[right]);
            
            if(heights[left] <= heights[right])
            {
               result += (maxLeft - heights[left]);
               left++;
            }
            else
            {
               result += (maxRight - heights[right]);
               right--;    
            }
        }
        
        return result;
    }