 public int[] findDiagonalOrder(int[][] matrix)
    {
        if (matrix.length == 0) 
            return new int[0];
        
        int row = 0, col = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m * n];
        
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = matrix[row][col];
            if ((row + col) % 2 == 0) // moving up
            { 
                if(col == n - 1) 
                { 
                    row++;
                }
                else if (row == 0)  
                { 
                    col++; 
                }
                else            
                { 
                    row--; 
                    col++;
                }
            } 
            else // moving down
            {                
                if(row == m - 1) 
                { 
                    col++; 
                }
                else if (col == 0)  
                { 
                    row++;
                }
                else            
                { 
                    row++; 
                    col--; 
                }
            }   
        }   
        
        return arr;
    }
	
	-----------------------------
	
	AntiDiagonal
	
	-----------------------------
	class Solution 
{
    public int[] findDiagonalOrder(int[][] matrix)
    {
        if (matrix.length == 0) 
            return new int[0];
        
        int row = 0, col = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m * n];
        
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = matrix[row][col];
            if ((row + col) % 2 == 0) // moving up
            { 
                if(col == n - 1) 
                { 
                    row++;
                }
                else if (row == 0)  
                { 
                    col++; 
                }
                else            
                { 
                    row--; 
                    col++;
                }
            } 
            else // moving down
            {                
                if(row == m - 1) 
                { 
                    col++; 
                }
                else if (col == 0)  
                { 
                    row++;
                }
                else            
                { 
                    row++; 
                    col--; 
                }
            }   
        }   
        
        return arr;
    }
}