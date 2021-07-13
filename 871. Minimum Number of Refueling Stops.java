  public int minRefuelStops(int target, int tank, int[][] stations) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int refills = 0;        
        int curPosition = tank;        
        int gasStationIndex = 0;
        
        while(curPosition < target)
        {
           while(gasStationIndex < stations.length && stations[gasStationIndex][0] <= curPosition)    
           {
               pq.offer(stations[gasStationIndex][1]);
               gasStationIndex++;
           }
            
           if(pq.isEmpty())
               return -1;
            
           curPosition += pq.poll();
           refills++;
        }
        
        return refills;
    }