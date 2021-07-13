 public int[][] matrixBlockSum(int[][] mat, int K) 
    {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rangeSum = build(mat);
        int[][] result = new int[m][n];
        for (int r = 0; r < m; r++) 
        {
            for (int c = 0; c < n; c++) 
            {
                int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
                r1++; c1++;
                r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                result[r][c] = rangeSum[r2][c2] - rangeSum[r2][c1 - 1] - rangeSum[r1 - 1][c2] + rangeSum[r1 - 1][c1 - 1];
            }
        }
        
        return result;
    }

    private int[][] build(int[][] A)
    {        
        int[][] sumCache = new int[A.length + 1][A[0].length + 1];
        for(int i = 1; i < sumCache.length; i++)
        {
            for(int j = 1; j < sumCache[0].length; j++)
            {
                sumCache[i][j] = A[i - 1][j - 1] + sumCache[i - 1][j] + sumCache[i][j - 1] - sumCache[i - 1][j - 1];
            }
        }  
        
        return sumCache;
    }