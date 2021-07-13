 public int[] sortArray(int[] nums) 
    {
       int lo = 0;
       int hi = nums.length - 1;
        
       return mergeSort(lo, hi, nums);       
    }
    
    int[] mergeSort(int lo, int hi, int[] nums)
    {
        if(lo > hi)
          return new int[0];
        
        if(lo == hi)
            return new int[]{ nums[lo] };
        
        int mid = lo + (hi - lo)/2;
        int[] left = mergeSort(lo, mid, nums);   
        int[] right = mergeSort(mid + 1, hi, nums);   
        
        return merge(left, right);
    }
    
    int[] merge(int[] a, int[] b)
    {
       if(a.length == 0)
           return b;
        
       if(b.length == 0)
          return a;
        
       int len = a.length + b.length;
       int[] res = new int[len];
        
       int index = 0;
       int i = 0; int j = 0;
        
       while(i < a.length || j < b.length)
       {
           int aVal = i < a.length ? a[i] : 50001;
           int bVal = j < b.length ? b[j] : 50001;
           
           if(aVal <= bVal)
           {
              res[index++] = aVal;
              i++;
           }
           else
           {
              res[index++] = bVal;
              j++;
           }
       }
       
        return res;
    }