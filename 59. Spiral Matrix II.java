public int[][] generateMatrix(int n) {        
        
        int max =  n * n;
        int[][] mat = new int[n][n];
        int rowMax =  n - 1, rowMin = 0;
        int colMax =  n - 1, colMin = 0;
        
        int count = 1;        
        while(count <= max)
        {
            for(int c = colMin; c <= colMax; c++)
            {
                mat[rowMin][c] = count++;
            }
            
            for(int r = rowMin + 1; r <= rowMax; r++)
            {
                mat[r][colMax] = count++;
            }
                        
            if(count <= max)
            {
               for(int c = colMax - 1;c >= colMin; c--)
               {
                  mat[rowMax][c] = count++;
               }
                
               for(int r = rowMax - 1; r > rowMin; r--)
               {
                  mat[r][colMin] = count++;
               }
            }
            
            rowMin++;
            rowMax--;
            colMin++;
            colMax--;
        }        
        
        return mat;
    }