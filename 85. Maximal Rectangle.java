 public int maximalRectangle(char[][] matrix) 
    {
        if(matrix.length == 0)
            return 0;
        int max = 0;
        int[] cur = new int[matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++)
        {            
            for(int j = 0; j < matrix[0].length; j++)
            {             
                cur[j] = (matrix[i][j] == '1') ? cur[j] + 1 : 0;
            }
            
            max = Math.max(max, maxArea(cur));
        }
        
        return max;
    }
    
    
    int maxArea(int[] heights)
    {     
        int max = 0;
        Stack<Integer> st = new Stack();        
        int index = 0;        
        while(index < heights.length)
        {            
            if(st.isEmpty() || heights[st.peek()] <= heights[index])
            {
                st.push(index++);
            }
            else
            {
                int top = st.pop();                  
                int area = heights[top] * index;
                if(!st.isEmpty())
                    area = heights[top] * (index - st.peek() - 1);
                max = Math.max(max, area);
            }            
        }
        
        return max;        
    }