 public int maximalSquare(char[][] matrix) 
     {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) 
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == '1') 
                {
                     if (i == 0 || j == 0) 
                     {
                        dp[i][j] = 1;
                        max = Math.max(dp[i][j], max);
                     } 
                     else
                     {
                         int curMax = 1 + (Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])));
                         max = Math.max(curMax, max);
                         dp[i][j] = curMax;    
                     }                        
                }
            }
        }

        return max * max;
    }