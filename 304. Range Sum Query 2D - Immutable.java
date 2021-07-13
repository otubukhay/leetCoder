    int[][] sumCache =  null;
    public NumMatrix(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0) 
            return;
        
        sumCache = new int[matrix.length + 1][matrix[0].length + 1];
        build(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {   
        row1++; col1++;  row2++; col2++;        
        return sumCache[row2][col2] - sumCache[row2][col1 - 1] - sumCache[row1 - 1][col2] + sumCache[row1 - 1][col1 - 1];
    }
    
    private void build(int[][] A)
    {        
        for(int i = 1; i < sumCache.length; i++)
        {
            for(int j = 1; j < sumCache[0].length; j++)
            {
                sumCache[i][j] = A[i - 1][j - 1] + sumCache[i - 1][j] + sumCache[i][j - 1] - sumCache[i - 1][j - 1];
            }
        }        
    }