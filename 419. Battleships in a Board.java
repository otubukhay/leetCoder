     public int countBattleships(char[][] board)
     {
        int m = board.length;
        if (m == 0)
        {
            return 0;
        }
       
        int n = board[0].length;
        int battleShips = 0;
        for(int i = 0; i < m; i++) 
        {
            for(int j = 0; j < n; j++) 
            {
                if(board[i][j] == 'X') 
                {
                   battleShips += ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) ? 0 : 1;
                }               
            }
        }
        return battleShips;
    }