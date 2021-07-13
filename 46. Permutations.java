 public List<List<Integer>> permute(int[] nums) 
    {
       List<List<Integer>> result = new ArrayList();
       process(0, result, nums);    
       return result; 
    }
    
    void process(int index, List<List<Integer>> result, int[] nums)
    {
        if(index == nums.length)    
        {
            List<Integer> current = new ArrayList();
            for(int i = 0; i < nums.length; i++)
            {
                current.add(nums[i]);
            }
            
            result.add(current);
            return;
        }
        
        for(int i = index; i < nums.length; i++)
        {
            swap(i, index, nums);
            process(index + 1, result, nums);
            swap(i, index, nums);
        }
    }
    
    void swap(int i, int j, int[] arr)
    {        
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }