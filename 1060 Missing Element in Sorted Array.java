 public int missingElement(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int missingElementsAtLastElement = getMissingNumbers(nums, hi);
        
		if (missingElementsAtLastElement < k) 
		{
            return nums[hi] + k - missingElementsAtLastElement;
        }
		
        while (lo < hi)
		{
            int m = lo + (hi - lo) / 2;
            int missingElementsAtMidElement = getMissingNumbers(nums, m);
            if (missingElementsAtMidElement < k)
			{
                lo = m + 1;
            } else 
			{
                hi = m;
            }
        }
		//lo will be the index of the smallest element with number of missing elements more than or equal to k
		//lo – 1 will be the index of the highest element with the number of missing element less than or equal to k
        return nums[lo - 1] + k - getMissingNumbers(nums, lo - 1);
    }

    int getMissingNumbers(int[] nums, int index) {

        return nums[index] - nums[0] - index;
    }