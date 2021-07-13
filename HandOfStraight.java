   public boolean isNStraightHand(int[] hand, int W)
    {
        if (hand.length % W != 0)
        {
            return false;
        }
        
        TreeMap<Integer, Integer> countHands = new  TreeMap<Integer, Integer>();
        for(int h : hand)
        {
           countHands.put(h, countHands.getOrDefault(h, 0) + 1);
        }
        
        while (countHands.size() > 0)
        {
            Integer curr = countHands.firstKey();
            for (int i = curr; i < curr + W; i++)
            {
                if (!countHands.containsKey(i))
                {
                   return false;
                }
                
                countHands.put(i, countHands.get(i) - 1);
                if(countHands.get(i) == 0)
                {
                   countHands.remove(i);
                }
            }
        }
        
        return true; 
    }