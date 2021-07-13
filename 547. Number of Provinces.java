    public int findCircleNum(int[][] M) 
    {
        int count = 0;        
        Set<Integer> set = new HashSet();
        for(int i = 0; i < M.length;i++ )
        {
            if(!set.contains(i))
            {
               countCircle(i, M, set);
               count++;
            }
        }
        
        return count;        
    }
    
    private void countCircle(int start, int[][]M, Set<Integer> set)
    {
        set.add(start);
        for(int friend = 0; friend < M[start].length; friend++)
        {  
            if(!set.contains(friend) && M[start][friend] == 1)
              countCircle(friend, M, set);
        }       
        
    }