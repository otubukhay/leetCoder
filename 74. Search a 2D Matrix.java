 public boolean searchMatrix(int[][] matrix, int target) {        
        if(matrix == null || matrix.length == 0)
            return false;
        
        int rows = matrix.length;
        int cols =  matrix[0].length;    
        
        int left = 0;
        int right = rows * cols - 1;
        
        while(left <= right)
        {            
            int mid = left + (right - left)/2;            
            if(matrix[mid / cols][mid % cols] == target)
            {
                return true;
            }
            
            if(matrix[mid / cols][mid % cols] > target)
            {
                right = mid - 1;            
            }
            else
            {
                left = mid + 1;
            }
            
        }
        
        return false;
    }