 public boolean isValidSudoku(char[][] board) 
    {
        Set<Character>[] rows = new Set[board.length];
        Set<Character>[] cols = new Set[board.length];
        Set<Character>[] boxes = new Set[board.length];
        
        for(int i = 0 ; i < 9; i++)
        {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)    
            {
                if(Character.isDigit(board[i][j]))
                {
                    if(rows[i].contains(board[i][j]))
                    {    
                       return false;
                    }
                    
                    if(cols[j].contains(board[i][j]))
                    {   
                       return false;
                    }
                    
                    int boxId = (i / 3 ) * 3 + j / 3;
                    if(boxes[boxId].contains(board[i][j]))
                    {    
                       return false;
                    }
                    
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    boxes[boxId].add(board[i][j]);
                }
            }
        }
        
        return true;
    }