public int singleNonDuplicate(int[] nums) 
    {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi - lo >= 2) 
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] != nums[mid + 1] && (nums[mid] != nums[mid - 1]))
            {
                return nums[mid];
            }
            
            if (nums[mid] == nums[mid + 1]) 
            {
                mid++;
            }

            if ((mid - lo + 1) % 2 == 0) 
            {
                lo = mid + 1;
            } 
            else 
            {
                hi = mid - 2;
            }
        }

        return nums[lo];
    }