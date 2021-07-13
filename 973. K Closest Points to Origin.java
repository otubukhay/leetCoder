    public int[][] kClosest(int[][] points, int k) 
    {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
       for(int[] point: points)  
       {
           pq.add(point);
           if(pq.size() > k)
           {
              pq.poll();    
           }
       }
      
       int[][] result = new int[k][2];
       int index = 0;
       while(!pq.isEmpty())
       {
           result[index++] = pq.poll();
       }
        
       return result;      
    }  
    
    int distance(int[] point)
    {
        return point[0] * point[0] + point[1] * point[1];
    }