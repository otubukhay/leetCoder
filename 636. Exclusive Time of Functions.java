public int[] exclusiveTime(int n, List<String> logs) 
{      
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();        
        int preTime = 0;        
        for(String log : logs) 
        {
            String[] arr = log.split(":");
            if(arr[1].equals("start")) 
            {
                if(!stack.isEmpty()) 
                {                    
                    result[stack.peek()] += Integer.parseInt(arr[2]) - preTime;
                }

                // arr[2] is the start of next interval, doesn't belong to current interval.
                stack.push(Integer.parseInt(arr[0]));
                preTime = Integer.parseInt(arr[2]);
            } 
            else 
            {
                result[stack.pop()] += Integer.parseInt(arr[2]) - preTime + 1;
                // arr[2] is end of current interval, belong to current interval. That's why we have +1 here
                preTime = Integer.parseInt(arr[2]) + 1;
                // pre means the start of next interval, so we need to +1
            }
        }

        return result;
}