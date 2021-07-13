public int leftMostColumnWithOne(BinaryMatrix binaryMatrix)
    {        
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);        
        
        int index = -1;
        int lo = 0;
        int hi = cols - 1;
        
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(containsOne(rows, mid, binaryMatrix))
            {
                index = mid;
                hi = mid - 1;
            }
            else
            {
               lo = mid + 1;    
            }
        }
        
        return index;
    }
    
    boolean containsOne(int rows, int col, BinaryMatrix binaryMatrix)
    {
        for(int row = 0; row < rows; row++)
        {
            if(binaryMatrix.get(row, col) == 1)            
                return true;
        }
        
        return false;
    }