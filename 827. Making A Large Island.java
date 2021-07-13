 
/*
827. Making A Large Island
Complexity Analysis Time Complexity: O(N^2), where N is the length and width of the grid.
Space Complexity: O(N^2), the additional space used in the depth first search by area.
*/
   int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int largestIsland(int[][] grid) 
    {        
        int m = grid.length;
        int n = grid[0].length;
        
        int max = 0;
        int isLandID = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                   int count = dfs(i, j, grid, isLandID, m, n);
                   max = Math.max(max, count);
                   map.put(isLandID, count);
                   isLandID++;
                }
            }     
        }
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                {
                   Set<Integer> set = new HashSet<>();
                   int count = 1;
                   for(int[] dir : directions)
                   {
                       int iNext= i + dir[0];
                       int jNext= j + dir[1];
                       
                       if(iNext >= 0 && iNext < m && jNext >= 0 && jNext < n && grid[iNext][jNext] > 0)
                       {
                           int id = grid[iNext][jNext];
                           if(!set.contains(id))
                           {
                               set.add(id);
                               count += map.get(id);
                           }
                       }
                   }
                    
                   max = Math.max(max, count);                   
                }
            }     
        }
        
        return max;            
    }
    
    int dfs(int i, int j, int[][]grid, int isLandID, int m, int n)
    {
         if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1)
            return 0;
        
         grid[i][j] = isLandID;
         int count = 1;
         for(int[] dir : directions)
         {
            int iNext= i + dir[0];
            int jNext= j + dir[1];                       
            count += dfs(iNext, jNext, grid, isLandID, m , n);
         }     
        
         return count;
    }