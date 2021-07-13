 void sortColors(int[] nums)
    {
        int n = nums.length;
        int zeroIndex = 0;
        int twoIndex = n - 1;        
        int index = 0;
        
        while(index <= twoIndex && zeroIndex < twoIndex)
        {
           if(nums[index] == 1)
           {
               index++;    
           }            
           else if (nums[index] == 0) 
           {
               swap(index++, zeroIndex++, nums);              
           }
           else if (nums[index] == 2) 
           {
               swap(index, twoIndex--, nums);   // check 1, 2, 0 test case to see why index doesnt increase   here                       
           }           
        }       
     }       
    
    void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }   