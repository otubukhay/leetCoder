class Solution 
{    
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1) 
        {
            return -1;
        }        
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        grid[0][0] = -1;

        int ans = 1;
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            for(int i = 0; i < size; i++) 
            {
                Node pop = queue.remove();
                if(pop.row == m - 1 && pop.col == n-1)
                {
                    return ans;
                }
                
                for (int k = 0; k < 8; k++) 
                {
                    int nextX = dir[k][0] + pop.row;
                    int nextY = dir[k][1] + pop.col;

                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0)
                    {
                        queue.add(new Node(nextX, nextY));
                        grid[nextX][nextY]= -1;
                    }
                }
            }
            
            ans++;
        }

        return -1;
    }
}

class Node
{
    public int row = 0;
    public int col = 0;
    
    public Node(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}