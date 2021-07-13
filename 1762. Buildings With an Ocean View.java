 public int[] findBuildings(int[] h) 
    {        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < h.length;i++)
        {
            while(!s.isEmpty() && h[i] >= h[s.peek()])
            {
                s.pop();
            }

            s.push(i);
        }

        int[] result = new int[s.size()];
        int index = result.length - 1;
        while(!s.isEmpty())
        {
			result[index--] = s.pop();
         }

        return result;
    }