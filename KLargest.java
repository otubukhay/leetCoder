 public int findKthLargest(int[] nums, int k) 
   {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi)
        {            
            int index = partition(nums, lo, hi);            
            if(index == k) 
            {
                return nums[k];
            } 
            else if (index > k) 
            {
                hi = index - 1;
            } 
            else 
            {
                lo = index + 1;
            }
        }
       
        return -1;
    }

    private int partition(int[] nums, int start, int end) 
    {
        int pivot = nums[end];// Take A[end] as the pivot, 
        int left = start;
        for (int i = start; i < end; i++) 
        {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);			
        }
        
        swap(nums, left, end);// Finally, swap A[end] with A[left]
        return left;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    