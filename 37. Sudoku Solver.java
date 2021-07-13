    //O(9! ^ 9)
	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1'; c <= '9'; c++)
                    {
                        if(isValid(board, i, j, c))
                        {
                            board[i][j] = c; //Put c for this cell         
                            if(solve(board))
                                return true; //If it's the solution return true
                            board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char cellValue)
    {
        for(int i = 0; i < 9; i++) 
        {
            if(board[i][col] == cellValue || board[row][i] == cellValue)
            { 
                return false; 
            }
        }
        
        int rs = (row /3) * 3;
        int cs = (col /3) * 3;        
        for(int i = rs; i < rs + 3; i++) 
        {
            for(int j = cs; j < cs + 3; j++) 
            {
               if(board[i][j] == cellValue) 
               { 
                  return false;
               }
            }
        }
        
        return true;
    }