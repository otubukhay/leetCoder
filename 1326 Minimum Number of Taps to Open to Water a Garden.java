
    /*
        We actually need to water the whole segment, instead of n + 1 point.
        The taps with value 0 can water nothing.


        Solution 1: Brute Force DP
        dp[i] is the minimum number of taps to water [0, i].
        Initialize dp[i] with max = n + 2
        dp[0] = [0] as we need no tap to water nothing.

        Find the leftmost point of garden to water with tap i.
        Find the rightmost point of garden to water with tap i.
        We can water [left, right] with onr tap,
        and water [0, left - 1] with dp[left - 1] taps.


        Complexity
        Time O(NR), where R = ranges[i] <= 100
        Space O(N)
    
    */
    public int minTaps(int n, int[] A) 
    {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i = 0; i <= n; ++i)
        {            
            int min = Math.max(i - A[i] + 1, 0);
            int max = Math.min(i + A[i], n);
            
            int numTapWithIOpen = dp[Math.max(0, i - A[i])] + 1;
            for (int j = min;j <= max; ++j)
            {
                dp[j] = Math.min(dp[j], numTapWithIOpen);
            }
            
        }
           
        return dp[n]  < n + 2 ? dp[n] : -1;
    }
	
	//
	public int minTaps(int n, int[] A) {
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        
        for(int tap = 0; tap <= n; tap++)
        {            
            int neededUpToTap = dp[Math.max(0,  tap -  A[tap])] + 1;
            
            int minGarden = Math.max(0, tap - A[tap] + 1);
            int maxGarden = Math.min(tap + A[tap], n);
            
            for(int location = minGarden; location <= maxGarden; location++)
            {
                dp[location] = Math.min(dp[location], neededUpToTap);;
            }
        }
        
        return dp[n] == n + 2 ? -1 : dp[n];
    }