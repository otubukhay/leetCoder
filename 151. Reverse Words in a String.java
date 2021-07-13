 public String reverseWords(String s) 
    {
        s = s.trim();
        String[] tokens = s.split("\\s+");
        StringBuilder b = new StringBuilder();
        
        for(int i = tokens.length - 1; i >= 0; i--)
        {
            if(i == 0)    
            {
                b.append(tokens[i]);    
            }
            else
            {
                 b.append(tokens[i]).append(" ");       
            }
        }
        
        return b.toString();
    }