public boolean isValidSudoku(char[][] board) 
   {
    // init data
    Set<Integer> [] rows = new HashSet[9];
    Set<Integer> [] columns = new HashSet[9];
    Set<Integer> [] boxes = new HashSet[9];
    
    for (int i = 0; i < 9; i++) 
    {
      rows[i] = new HashSet<Integer>();
      columns[i] = new HashSet<Integer>();
      boxes[i] = new HashSet<Integer>();
    }

    // validate a board
    for (int i = 0; i < 9; i++) 
    {
      for (int j = 0; j < 9; j++) 
      {
        char num = board[i][j];
        if (num != '.') 
        {
          int n = (int)num;
          int box_index = (i / 3 ) * 3 + j / 3;
            
            // check if this value has been already seen before
          if (rows[i].contains(n) || columns[j].contains(n) || boxes[box_index].contains(n))
             return false;

          // keep the current cell value
          rows[i].add(n);
          columns[j].add(n);
          boxes[box_index].add(n);          
        }
      }
    }

    return true;
  }