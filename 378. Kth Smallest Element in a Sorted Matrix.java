    /* Solution 1 : Heap
        Here is the step of my solution:

        Build a minHeap of elements from the first row.
        Do the following operations k-1 times :
        Every time when you poll out the root(Top Element in Heap), you need to know the row number 
        and column number of that element(so we can create a tuple class here), replace    that root with the next element from the same             column. After you finish this problem, thinks more :

        For this question, you can also build a min Heap from the first column, and 
        do the similar operations as above.(Replace the root with the next element from the same row)
        What is more, this problem is exact the same with Leetcode373 Find K Pairs with Smallest Sums, 
        I use the same code which beats 96.42%, after you solve this problem, you can     check with this link:
        https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42
    */
    
	//O(NLog K)
    public int kthSmallest(int[][] matrix, int k) 
    {        
        int n = matrix.length;        
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a, b) -> a[2] - b[2]);
        for(int j = 0; j < n; j++)
        {          
            pq.offer(new Integer[]{ 0, j, matrix[0][j] });
        }
        
        for(int i = 1; i <= k - 1; i++) 
        {
            Integer[] t = pq.poll();            
            if(t[0] < n - 1)    
			{           
				pq.offer(new Integer[]{ t[0] + 1, t[1], matrix[t[0] + 1][t[1]] });
			}
        }
        
        return pq.poll()[2];        
    }    
	
	
	OR Binary Search

    public int kthSmallestBS(int[][] matrix, int k)
    {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo <= hi) 
        {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k)
            {
                lo = mid + 1;
            }
            else
            {                
                 hi = mid - 1;
            }
            
        }
        return lo;
    }
    
    private int getLessEqual(int[][] matrix, int val)
    {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) 
        {
            if (matrix[i][j] > val) 
            {
                i--;
            }
            else 
            {
                res += i + 1;
                j++;
            }
        }
        
        return res;
    }