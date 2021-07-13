public int maxArea(int[] height) {
        if(height.length  == 0)
            return 0;
        
        int lo = 0;
        int hi = height.length - 1;
        
        int max = 0;
        while(lo < hi)
        {
            int temp = Math.min(height[lo], height[hi]) * (hi - lo);
            max = Math.max(max, temp);
            
            if(height[lo] <= height[hi])
            {
                lo++;    
            }
            else
            {
                hi--;    
            }
        }
        
        
        return max;
    }