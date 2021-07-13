     public boolean canJump(int[] nums) 
     {         
        int ladderEnd = 0;        
        for(int startingPoint = 0; startingPoint < nums.length; startingPoint++)
        {
            if(startingPoint > ladderEnd)
                return false;
       
            ladderEnd = Math.max(ladderEnd, startingPoint + nums[startingPoint]);                  
        }
        
        return  true;
    }