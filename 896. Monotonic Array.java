public boolean isMonotonic(int[] A) {
        if(A.length == 1)
            return true;
        
        int n =  A.length;
        boolean increasing = A[0] < A[n - 1] ? true : false; // Get trend from first and last        
        for(int i = 1; i < n ; i++)
        {
            if((increasing && A[i] < A[i - 1]) || (!increasing && A[i] > A[i - 1]))
                return false;           
        }
        
        return true;
    }