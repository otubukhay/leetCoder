 public int minMeetingRooms(int[][] intervals) {
         
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int rooms = 1;
        
        PriorityQueue<Integer> endings = new PriorityQueue<Integer>((a, b) -> a - b);
        endings.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++)
        {
             int[] current = intervals[i];
             if(current[0] >= endings.peek())
             {
                endings.remove();               
             }
             else
             {
                 rooms++;                 
             }
            
             endings.offer(current[1]);
        }
        
        return rooms;
    }