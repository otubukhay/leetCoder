
    public void rotate(int[] nums, int k) 
    {
        if(k == 0)
            return;
        
        int n = nums.length;
        k = k % n;        
        swap(0, n - k - 1, nums);
        swap(n - k, n - 1, nums);
        
        swap(0, n - 1,  nums);        
    }
    
    void swap(int i, int j, int[] nums)
    {
        while(i < j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;    
            
            i++;
            j--;
        }
    }