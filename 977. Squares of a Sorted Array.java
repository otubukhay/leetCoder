 public int[] sortedSquares(int[] A) {
                
        int i = 0;
        while(i < A.length && A[i] < 0)
		{
            i++;           
        }
        
        int j = i - 1;
        
        int[] result = new int[A.length];
        int index = 0;
        while(j >= 0 || i < A.length)
        {
            int left =  (j >= 0) ? A[j] * A[j] : Integer.MAX_VALUE;
            int right = (i < A.length) ? A[i] * A[i] : Integer.MAX_VALUE;
            
            if(left <= right)
            {
                result[index++] = left;
                j--;
            }
            else
            {
                result[index++] = right;
                i++;
            }
        }
        
        return result;
    }
	
	------------------------------------------------------------
	
	public int[] sortedSquares(int[] A) 
    {      
        int[] ans = new int[A.length];
     
        int start = 0, end = A.length - 1;
        int i = end; // insert position.
        while (start <= end) 
        { 
            int pow1 = A[start] * A[start];
            int pow2 = A[end] * A[end];
            if (pow1 >= pow2)
            {
                ans[i--] = pow1;
                start++;
            } 
            else 
            {
                ans[i--] = pow2;
                end--;
            }
        }
        return ans;
	}