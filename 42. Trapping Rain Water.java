    public int trap(int[] height) 
    {       
        if(height.length <= 2)
            return 0;
        
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = 0;
        int maxRight = 0;
        
        int result = 0;
        while(left <= right)
        {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            
            if(height[left] <= height[right])
            {
                result+= (maxLeft - height[left]);
                left++;
            }
            else
            {
                result+= (maxRight - height[right]);
                right--;
            }
        }
         
        return result;
    }