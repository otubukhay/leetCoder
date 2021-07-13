/*
Complexity analysis

Time complexity: O(n). Single iteration of O(n).
Each element can be visited atmost twice, once by the right pointer(ii) and (atmost)once by the left pointer.
Space complexity: O(1) extra space. Only constant space required for left, sum, ans and ii.
*/
public int minSubArrayLen(int target, int[] nums) 
    {
        int start = 0;
        int sum = 0;
        
        int minSize = nums.length + 1;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            while(sum >= target)
            {
               minSize = Math.min(minSize, i - start + 1);
               sum -= nums[start];
               start++;
            }                
        }
        
        return minSize == nums.length + 1 ? 0 :  minSize;
    }