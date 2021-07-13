 public int maxIncreaseKeepingSkyline(int[][] grid)
    {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];        
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)    
            {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        
        int increment = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)    
            {
                int max = Math.min(rowMax[i], colMax[j]);
                increment += Math.max(0, max - grid[i][j]);
            }
        }
        
        return increment;
    }