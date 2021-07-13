class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) 
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] preSum = new int[rows + 1][cols];
        
        for (int j = 0; j < cols; j++) 
        {
            for (int i = 0; i < rows; i++) 
            {
                preSum[i + 1][j] = preSum[i][j] + matrix[i][j];
            }
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();        
        for (int rowStart = 0; rowStart < rows; rowStart++) 
        {
            for (int row = rowStart; row < rows; row++)
            {
                map.clear();
                int sum = 0;
                for (int col = 0; col < cols; col++) 
                {
                    sum += preSum[row + 1][col] - preSum[rowStart][col];                    
                    if (sum == target) 
                    {
                        res++;
                    }
                    
                    int offset = sum - target;
                    if (map.containsKey(offset))
                    {
                        res += map.get(offset);
                    }
                    
                     map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        
        return res;
    }
}