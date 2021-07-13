class Solution 
{
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] A) 
    {
        int m = A.length, n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();

        boolean done = false;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(A[i][j] == 1) 
                {
                    markFirstIsland(i, j, queue, A);                    
                    return searchSecondIsland(queue, A);
                }
            }
        }

        return -1;
    }

    int searchSecondIsland(Queue<int[]> queue, int[][] A) 
    {
        int distance = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int k = 1; k <= size; k++)
            {
                int[] current = queue.remove();                
                for (int[] dir : directions) 
                {
                    int nexti = current[0] + dir[0];
                    int nextj = current[1] + dir[1];

                    if (nexti >= 0 && nexti < A.length && nextj >= 0 && nextj < A[0].length && A[nexti][nextj] != -1) 
                    {
                        if(A[nexti][nextj] == 1)
                        {
                            return distance;
                        } 
                        else 
                        {
                            A[nexti][nextj] = -1;
                            queue.add(new int[]{nexti, nextj});
                        }

                    }
                }

            }
            distance++;
        }
        return -1;
    }

    void markFirstIsland(int i, int j, Queue<int[]> queue, int[][] A) 
    {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1) {
            return;
        }

        queue.add(new int[]{i, j});
        A[i][j] = -1;

        for (int[] dir : directions) {
            dfs(i + dir[0], j + dir[1], queue, A);
        }
    }
}