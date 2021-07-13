 public int minEatingSpeed(int[] piles, int H) 
 {        
        int low = 1;
        int high = -1;        
        
        for(int pile : piles)
		{
            high = Math.max(high, pile);
		}
        
        int minimum = high;        
        while(low <= high)
        {
            int mid =  low + (high - low)/2;
            if(canFinish(piles, mid, H))
            {
               minimum = mid;
               high = mid - 1;
            }
            else
            {
               low = mid + 1;
            }
        }
        
        return minimum;
    }
    
    boolean canFinish(int[] piles, int speed, int hours)
    {
        int timeTaken = 0;
        for(int pile : piles)
        {            
            timeTaken += pile/speed;
            timeTaken += ((pile % speed > 0) ?  1 : 0);
        }
        
        return timeTaken <= hours;
    }