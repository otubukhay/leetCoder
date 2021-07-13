 public int[] maxSlidingWindow(int[] nums, int k)
    {   
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<Integer>(); 
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            purge(queue, i, k);
            insertGreater(queue,i, k, nums);
            
            if(i - k + 1 >= 0)
            {
                result[index++] = nums[queue.peekFirst()];
            }            
        }
        
        return result;
    }
    
    void purge(Deque<Integer> q, int index, int k)
    {
        if(!q.isEmpty() && index - q.peekFirst() >= k)
        {
           q.removeFirst();
        }
    }
    
    void insertGreater(Deque<Integer> q, int index, int k, int[] nums)
    {
        while(!q.isEmpty() && nums[index] >= nums[q.peekLast()])
        {
           q.removeLast();
        }
        
        q.offerLast(index);
    }