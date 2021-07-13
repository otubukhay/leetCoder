class Solution 
{
    public int N = 0;    
    public int largestIsland(int[][] grid) 
    {
        N = grid.length;       
        int index = 2, res = 0;
        HashMap<Integer, Integer> area = new HashMap<>();
        for (int x = 0; x < N; ++x)
        {
            for (int y = 0; y < N; ++y)
            {
                if (grid[x][y] == 1) 
                {
                    area.put(index, dfs(grid, x, y, index));
                    res = Math.max(res, area.get(index++));
                }
            }
        }

        //traverse every 0 cell and count biggest island it can conntect
        for (int x = 0; x < N; ++x)
        { 
            for (int y = 0; y < N; ++y)
            {
                if (grid[x][y] == 0) 
                {
                    Set<Integer> seen = new HashSet<>();
                    int cur = 1;
                    for (Pair<Integer, Integer> p : move(x, y)) 
                    {
                        index = grid[p.getKey()][p.getValue()];
                        if (index > 1 && !seen.contains(index)) 
                        {
                            seen.add(index);
                            cur += area.get(index);
                        }
                    }

                    res = Math.max(res, cur);
                }
            }
        }
        
        return res;
    }

    public List <Pair<Integer, Integer>> move(int x, int y) {
        ArrayList <Pair<Integer, Integer>> res = new ArrayList<>();
        if (valid(x, y + 1)) res.add(new Pair<Integer, Integer>(x, y + 1));
        if (valid(x, y - 1)) res.add(new Pair<Integer, Integer>(x, y - 1));
        if (valid(x + 1, y)) res.add(new Pair<Integer, Integer>(x + 1, y));
        if (valid(x - 1, y)) res.add(new Pair<Integer, Integer>(x - 1, y));
        return res;
    }

    public boolean valid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public int dfs(int[][] grid, int x, int y, int index) {
        int area = 0;
        grid[x][y] = index;
        for (Pair<Integer, Integer> p : move(x, y))
            if (grid[p.getKey()][p.getValue()] == 1)
                area += dfs(grid, p.getKey(), p.getValue(), index);
        return area + 1;
    }
}

-------------------------------------------------------------------------------------------------------------


public int largestIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if(m <= 0 || n <= 0) {
            return 0;
        }

        boolean found = false;
        
        int max = 0;
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                boolean[][] visited = new boolean[m][n];
                if(grid[i][j] == 0)
                {
                    found = true;
                    grid[i][j] = 1;
                    max = Math.max(dfs(grid, visited, i, j), max);
                    grid[i][j] = 0;
                }
            }
        }
        return found ? max : m * n;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j)
    {
        if(i < 0|| j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
        {
            return 0;
        }
        
        visited[i][j] = true;
        int result = 0;
        int left = dfs(grid, visited, i - 1,j);
        int right = dfs(grid, visited, i + 1,j);
        int top = dfs(grid, visited, i, j - 1);
        int bottom = dfs(grid, visited, i, j + 1);
        result = 1 + left + right + top + bottom;
        
        return result;
    }
	----------------------------------------------------------------------------