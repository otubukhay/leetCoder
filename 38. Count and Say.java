 public String countAndSay(int n) 
    {      
        String result = "1";
        
        for(int i = 1; i < n; i ++) {
            result = build(result);
        }
        
        return result;
    }
    
    private String build(String result) 
    {
        StringBuilder builder = new StringBuilder();        
        int index = 0;
        while(index < result.length()) 
        {
            char currentChar = result.charAt(index);
            int count = 0;            
            while(index < result.length() && result.charAt(index) == currentChar)
            {
                index++;
                count++;
            }
            
            builder.append(String.valueOf(count));
            builder.append(currentChar);
        }
        
        return builder.toString();
    }