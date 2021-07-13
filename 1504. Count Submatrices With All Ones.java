class Solution
{    
     public int numSubmat(int[][] mat) 
     {
        int M = mat.length;
        int N = mat[0].length;
        int res = 0;
        
        int[] h = new int[N]; // the h[j] means: number of continuous 1 in column j from row i up to row 0
        for (int i = 0; i < M; ++i) 
        {
            for (int j = 0; j < N; ++j) 
            {
                h[j] = (mat[i][j] == 0 ? 0 : h[j] + 1);
            }

            res += helper(h);
        }
        
        return res;
    }

    private int helper(int[] h)
    {
        int[] sum = new int[h.length]; // sum[i] means the number of submatrices with the column "i" as the right border.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h.length; ++i) 
        {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i])
            {
                stack.pop();
            }
            
            if (!stack.isEmpty())
            {
                int preIndex = stack.peek();
                sum[i] = sum[preIndex] + h[i] * (i - preIndex);
            } 
            else 
            {
                sum[i] = h[i] * (i + 1);
            }
            
            stack.push(i);
        }
        int res = 0;
        for (int s : sum) {
            res += s;
        }
        return res;
    }
}