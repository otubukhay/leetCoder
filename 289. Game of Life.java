 int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    public void gameOfLife(int[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)    
            {
                int numLiving = 0;
                for(int[] dir : directions)
                {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];
                    
                    if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length)
                    {
                        if(board[nextX][nextY] == 1 || board[nextX][nextY] == 2)
                        {
                            numLiving++;
                        }
                    }                    
                }
                
                if(board[i][j] == 1)
                {
                   if(numLiving < 2 || numLiving > 3) 
                   {
                      board[i][j] = 2;
                   }
                }
                else
                {
                   if(numLiving == 3) 
                   {
                      board[i][j] = 3;
                   }
                }
            }
        }
        
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)    
            {
                if((board[i][j] % 2) == 1)
                {
                   board[i][j] = 1;    
                }
                else
                {
                    board[i][j] = 0;
                }
            }
        }
            
    }