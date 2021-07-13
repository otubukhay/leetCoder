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
            List<Integer> arr = new ArrayList<>();  
            for(int num : nums)
            {
               arr.add(num);
            }
            
            result.add(arr);
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

***************************************************************************************************

    public List<List<Integer>> permute(int[] nums)
    {
       List<List<Integer>> list = new ArrayList<>();      
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums)
    {
        if(tempList.size() == nums.length)
        {
            list.add(new ArrayList<>(tempList));
        } 
        else
        {
            for(int i = 0; i < nums.length; i++)
            { 
                if(!tempList.contains(nums[i])) 
                {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                } 
            }
        }
    } 

********************************************************************************************************
    public List<List<Integer>> permute2(int[] nums) 
    {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), new HashSet<>(), nums);
        return ret;
    }
    
    private void backtrack(List<List<Integer>> ret, List<Integer> tmpList, 
		Set<Integer> tmpSet, int[] nums) 
    {
        if (tmpSet.size() == nums.length) 
        {
            ret.add(new ArrayList<>(new ArrayList<>(tmpList)));
            return;
        }

        for (int i = 0; i < nums.length; i++) 
        {
            if (tmpSet.contains(nums[i])) 
                continue;
            
            tmpSet.add(nums[i]);
            tmpList.add(nums[i]);
            
            backtrack(ret, tmpList, tmpSet, nums);
            
            tmpSet.remove(tmpList.get(tmpList.size() - 1));
            tmpList.remove(tmpList.size() - 1);
        }
    }