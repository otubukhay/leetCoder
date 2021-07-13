 public int maxAreaOfIsland(int[][] grid) 
    {     
        int maxResult = 0;
        for(int i = 0 ; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
              if(grid[i][j] == 1)
              {
                 int max = area(i, j, grid);
                 maxResult = Math.max(max, maxResult);
              }                
            }            
        }
        
        return maxResult;
    }
    
    int area(int r, int c, int[][] grid) 
    {
       if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
           return 0;
        
       grid[r][c] = 0;
       return 1 +  area(r + 1, c, grid) + area(r - 1, c, grid)  + 
                       area(r, c + 1, grid) + area(r, c - 1, grid);
    }