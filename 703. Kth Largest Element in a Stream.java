    PriorityQueue<Integer> pq = null;
    int k = 0;
    public KthLargest(int k, int[] nums) 
    {
        pq = new PriorityQueue<Integer>((a, b) -> a - b);
        this.k = k;
        for(int n : nums)
        {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
    }
    
    public int add(int val) 
    {
         pq.add(val);
         if(pq.size() > k)
            pq.poll();
        
         return pq.peek();
    }