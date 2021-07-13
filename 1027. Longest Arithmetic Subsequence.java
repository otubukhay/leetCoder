    public int longestArithSeqLength(int[] A) 
	{        
        int[][] dp = new int[A.length][A.length];
        for(int[] row : dp)
		{
			Arrays.fill(row, 2);
		}
        
        Map<Integer, Integer> map = new HashMap<>();        
        int max = 2;
        for(int j = 0; j < A.length; j++)
        {
            for(int k = j + 1; k < A.length; k++)
            {
               int firstNumber = 2 * A[j] - A[k];
               if(map.containsKey(firstNumber))
               {
                  int index = map.get(firstNumber);
                  dp[j][k] = dp[index][j] + 1;
                  max = Math.max(max, dp[j][k]);
               }
            }   
            
            map.put(A[j], j);
        }
        
        return max;
    }