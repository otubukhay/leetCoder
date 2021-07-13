public int minTotalDistance(int[][] grid) 
    {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                if(grid[row][col] == 1)
                {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }   

        Collections.sort(rows);
        Collections.sort(cols);     
        
        int size = rows.size()/2;
        int distance  = 0;

        int meetX = rows.get(size);
        int meetY = cols.get(size);
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                if(grid[row][col] == 1)
                {
                   distance += findDistance(row, col, meetX, meetY);
                }
            }
        }   

        return distance;
    }

   int findDistance(int x, int y, int i, int j)
   {
       return Math.abs(x - i) + Math.abs(y - j);
   }