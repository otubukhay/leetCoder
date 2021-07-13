 public void setZeroes(int[][] matrix) 
 {
        boolean firstRowHas = false, firstColHas = false;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++) 
            {
                if(matrix[i][j] == 0)
                {
                    if(i == 0) 
                        firstRowHas = true;
                    if(j == 0) 
                        firstColHas = true;
                    
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
          
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }               
              
            }
        }
          
        if(firstRowHas) 
        {
            for(int j = 0; j < matrix[0].length; j++) 
            {
                matrix[0][j] = 0;
            }
        }
          
        if(firstColHas) 
        {
            for(int i = 0; i < matrix.length; i++) 
            {
                matrix[i][0] = 0;
            }
        }

    }