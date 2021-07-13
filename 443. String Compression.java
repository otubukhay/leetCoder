 public int compress(char[] chars) 
    {       
        int index = 0;
        int result = 0;
        
        while(index < chars.length)
        {
            int count = 0;
            char cur = chars[index];
            
            while(index < chars.length && chars[index] == cur)
            {
                index++;
                count++;
            }
            
            chars[result++] = cur; //KOKO is that U dont need additional space for result. Just overrite input array
            if(count > 1)
            {
                for(char c :  String.valueOf(count).toCharArray())    
                {
                    chars[result++] = c;
                }
            }
            
        }
        
        return result;
    }