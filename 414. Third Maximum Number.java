    public int thirdMax(int[] nums) 
    {
        Integer firstMaximum = null;
        Integer secondMaximum = null;
        Integer thirdMaximum = null;
        
		for(Integer n : nums) 
        {
            if (n.equals(firstMaximum) || n.equals(secondMaximum) || n.equals(thirdMaximum)) 
                continue;
           
            if (firstMaximum == null || n > firstMaximum) 
            {
                thirdMaximum = secondMaximum;
                secondMaximum = firstMaximum;
                firstMaximum = n;
            } 
            else if (secondMaximum == null || n > secondMaximum) 
            {
                thirdMaximum = secondMaximum;
                secondMaximum = n;
            } 
            else if (thirdMaximum == null || n > thirdMaximum)
            {
                thirdMaximum = n;
            }
        }
         
        return thirdMaximum == null ? firstMaximum : thirdMaximum;
    }