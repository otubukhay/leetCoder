    public int[] topKFrequent(int[] nums, int k) 
	{                       
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));        
        for(int num : map.keySet())
        {
            q.add(num);
            if(q.size() > k)
            {
                q.remove();
            }
        }
        
        int[] arr = new int[q.size()];
        int index = 0;
        while(!q.isEmpty())
        {
            arr[index++] = q.remove();
        }
        
        return arr;     
    }