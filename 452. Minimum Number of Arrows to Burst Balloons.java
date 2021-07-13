 public int findMinArrowShots(int[][] points) 
    {
        if(points.length == 0)        
            return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1;
        
        int[] last = points[0];
        
        for(int i = 1; i < points.length; i++)
        {
            if(points[i][0] > last[1])   
            {
                arrow++;    
                last = points[i];
            }            
        }
        
        return arrow;
    }