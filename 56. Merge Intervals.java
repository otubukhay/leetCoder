 //On(logn)
 public int[][] merge(int[][] intervals) {
        List<int[]> ls = new ArrayList();
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);    
        ls.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] > ls.get(ls.size() - 1)[1])
            {
               ls.add(intervals[i]);
            }
            else
            {
              
                ls.get(ls.size() - 1)[1] = Math.max(ls.get(ls.size() - 1)[1], intervals[i][1]);
                
            }
        }       
      
        return ls.toArray(new int[ls.size()][]);
    }