 public int slidingPuzzle(int[][] board) 
 {
        String target = "123450";        
        String start = "";
        for(int i = 0; i < board.length; i++) 
        {
            for(int j = 0; j < board[0].length; j++) 
            {
                start += board[i][j];
            }
        }
       
        Set<String> visited = new HashSet<>();      
		// [0 1 2]
		// [3 4 5]
        int[][] directions = new int[][] {{ 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }};
        
		Queue<String> queue = new LinkedList<>();        
		queue.offer(start);
        visited.add(start);        
        int moves = 0;
        while (!queue.isEmpty()) 
        {           
            int size = queue.size();
            for(int i = 1; i <= size; i++)
            {
                String cur = queue.poll();
                if(cur.equals(target)) 
                {
                    return moves;
                }
                
                int zero = cur.indexOf('0');               
                for(int dir : directions[zero]) 
                {
                    String next = swap(cur, zero, dir);
                    if (!visited.contains(next)) 
                    {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            
            moves++;
        }
       
        return -1;
    }

    private String swap(String str, int i, int j) 
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }