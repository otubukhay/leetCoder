public int maximumMinimumPath(int[][] A)
 {
        if (A.length == 0) 
		{
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
        boolean[][] seen = new boolean[m][n];
        seen[0][0] = true;
        pq.offer(new int[]{0, 0, A[0][0]});
        int max = 0;
        while (!pq.isEmpty()) 
        {
            int[] cur = pq.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) 
            {
                return cur[2];
            }
            
            for (int[] dir : dirs) 
            {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !seen[nextX][nextY]) 
                {
                    int min = Math.min(cur[2], A[nextX][nextY]);
                    seen[nextX][nextY] = true;
                    pq.offer(new int[]{nextX, nextY, min});
                }
            }
        }
        return -1;
    }