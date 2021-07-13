 public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack();
        int[] result = new int[T.length];
        for(int index = 0; index < result.length; index++)
        {            
            while(!stack.isEmpty() && T[index] > T[stack.peek()])
            {
               int top = stack.pop();
               result[top] =  index - top;
            }
            
            stack.push(index);            
        }
        
        return result;
    }