public int singleNonDuplicate(int[] nums)
{
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi)
     	{
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] != nums[mid + 1] && (mid > 0 && nums[mid] != nums[mid - 1]))
            {
                return nums[mid];
            }

            int index = mid;
            if (nums[mid] == nums[mid + 1]) {
                index++;
            }

            if ((index - lo + 1) % 2 == 0) 
			{
                lo = index + 1;
            } 
			else 
			{
                hi = index - 2;
            }
        }

        return nums[lo];
}
