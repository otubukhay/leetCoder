public int[] maxSumOfThreeSubarrays(int[] nums, int k) 
    {
        int len = nums.length;
        int n = len - k + 1;
        int[] dp = buildSumArray(nums, k);
        int[] left = buildMaxLeft(dp);
        int[] right = buildMaxRight(dp);
        
        int first = -1, second = -1, third = -1;     
        boolean isSet = false;
        for (int i = k; i < n - k; i++) 
        {
            if(!isSet || dp[first] + dp[second] + dp[third] < dp[left[i - k]] + dp[i] + dp[right[i + k]]) 
            {
                first = left[i - k];
                second = i;
                third = right[i + k];
                isSet = true;
            }
        }

        return new int[]{ first, second, third };
    }
    
    int[] buildMaxRight(int[] sum)
    {
        int n = sum.length;
        int[] right = new int[n];        
        int maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) 
        {
            if (sum[i] >= sum[maxIndex]) 
            {
                maxIndex = i;
            }

            right[i] = maxIndex;
        }

        return right;
    }
    
    int[] buildMaxLeft(int[] sum)
    {
        int n = sum.length;
        int[] left = new int[n];        
        int maxIndex = 0;

        for (int i = 0; i < n; i++) 
        {
            if (sum[i] > sum[maxIndex])
            {
                maxIndex = i;
            }

            left[i] = maxIndex;
        }
        
        return left; 
    }
    
     int[] buildSumArray(int[] nums, int k)
    { 
        int n = nums.length - k + 1;
        int[] dp = new int[n];
        int sum = 0;
        
        int index = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            sum += nums[i];                     
            if (i >= k - 1) 
            {
                dp[index++] = sum;
                sum -= nums[i - k + 1];
            }
        }
        
        return dp;
    }
    