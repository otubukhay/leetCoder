/*
        We need to keep at most 200 smallest sums. 1 <= k <= min(200, n ^ m)
        For the input with one row the answer is the smallest k-th element or top of the max priority queue of size k.

        Algorithm:
        Calculate max priority queue of sizr k for the first row.

        Add the rest rows one by one to the max priority queue and make sure that max priority queue size is less than or equal to k.

        Time: O(m * n * k * log(k))
        Space: O(k)
    */

    public int kthSmallest(int[][] mat, int k) 
    {
        int col = Math.min(mat[0].length, k);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat)
        {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            while(!pq.isEmpty())
            {
                int i = pq.poll();
                for (int c = 0; c < col; c++) 
                {
                    nextPq.add(i + row[c]);
                    // keep pq size <= k
                    if (nextPq.size() > k) 
                    {
                        nextPq.poll();
                    }
                }
            }
            
            pq = nextPq;
        }
        
        return pq.poll();
    }