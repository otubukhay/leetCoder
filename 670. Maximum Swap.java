public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) 
        {
            last[Character.getNumericValue(A[i])] = i;
        }

        for (int i = 0; i < A.length; i++) 
        {
            for (int d = 9; d >= 0; d--) 
            {
                if (d > A[i] - '0' && last[d] > i) 
                {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        
        return num;
    }