 /*
 Let TT be the target value, and NN be the number of elements in the input array.

Time Complexity: O(T* N)

Thanks to the memoization technique, for each invocation of combs(remain), it would be evaluated only once, for each unique input value. 
In the worst case, we could have TT different input values.

For each invocation of combs(remain), in the worst case it takes O(N) time for the non-recursive part.

To sum up, the overall time complexity of the algorithm is O(T * N).

Space Complexity: O(T)

Due to the recursive function, the algorithm will incur additional memory consumption in the function call stack. In the worst case, the recursive function can pile up to TT times. As a result, we would need \mathcal{O}(T)O(T) space for the recursive function.

In addition, since we applied the memoization technique where we keep the intermediate results in the cache, we would need addtionally O(T) space.

To sum up, the overall space complexity of the algorithm is O(T).
 */
 
 private int[] dp;
    public int combinationSum4(int[] nums, int target) 
    {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) 
    {
        if(dp[target] != -1)
        {
            return dp[target];
        }
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) 
        {
            if(target >= nums[i]) 
            {
                res += helper(nums, target - nums[i]);
            }
        }
        
        dp[target] = res;
        return res;
    }
	
	*************************************
	public int combinationSum4(int[] nums, int target) {
        // minor optimization
        // Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int combSum = 1; combSum < target + 1; ++combSum) {
            for (int num : nums) {
                if (combSum - num >= 0)
                    dp[combSum] += dp[combSum - num];
                // minor optimizaton, early stopping
                // else
                //     break;
            }
        }
        return dp[target];
    }