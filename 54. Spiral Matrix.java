  public List <Integer> spiralOrder(int[][] matrix) 
    {
        List ans = new ArrayList();
        if (matrix.length == 0)
        {
            return ans;
        }
       
        int rStart = 0, rEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        
        while(rStart <= rEnd && colStart <= colEnd) 
        {
            for(int c = colStart; c <= colEnd; c++) 
            {
                ans.add(matrix[rStart][c]);
            }
            
            for(int r = rStart + 1; r <= rEnd; r++)
            { 
                ans.add(matrix[r][colEnd]);
            }            
            
            if(rStart < rEnd && colStart < colEnd) 
            {
                for (int c = colEnd - 1; c >= colStart; c--)
                {
                    ans.add(matrix[rEnd][c]);
                }    
                
                for (int r = rEnd - 1; r > rStart; r--)
                {
                    ans.add(matrix[r][colStart]);
                }
            }           
            
            rStart++;
            rEnd--;
            colStart++;
            colEnd--;
        }
        
        return ans;
    }
    