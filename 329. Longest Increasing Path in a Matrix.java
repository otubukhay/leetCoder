 int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public int longestIncreasingPath(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int max = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];        
        for(int[] cur : cache)
        {
            Arrays.fill(cur, -1);            
        }
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
               int val = getMax(i, j, matrix, cache);
               max = Math.max(max, val);
            }
        }
        
        return max;
    }
    
    int getMax(int i, int j, int[][] grid, int[][] cache)
    {
        if(cache[i][j] != -1)
            return  cache[i][j];        
       
        int maxChild = 0;
        for(int[] dir : dirs)
        {
            int iNext = i + dir[0];
            int jNext = j + dir[1];
            
            if(iNext >= 0 && iNext < grid.length && jNext >= 0 && jNext < grid[0].length
                  && grid[i][j] < grid[iNext][jNext])
            {
               int temp = getMax(iNext, jNext, grid, cache);
               maxChild = Math.max(temp, maxChild);
            }
        }
       
        cache[i][j] = 1 + maxChild;
        return cache[i][j];
    }