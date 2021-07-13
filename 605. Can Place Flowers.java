 public boolean canPlaceFlowers(int[] flowerbed, int n) 
 {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) 
		{
            if(flowerbed[i] == 0) 
			{
	           //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
               int nextBed = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
               int prevBed = (i == 0) ? 0 : flowerbed[i - 1];
               if(nextBed == 0 && prevBed == 0) 
			   {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        
        return count == n;
 }