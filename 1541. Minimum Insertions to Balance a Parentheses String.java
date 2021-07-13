class Solution 
{
    public int minInsertions(String s) 
    {        
        int count = 0;        
        int index = 0;
        
        int state = 0;
        while(index < s.length())
        {
            if(s.charAt(index) == '(')    
            {
                state++;
                index++;
            }
            else
            {                
                if(state <= 0)
                {
                    if(index + 1 < s.length() && s.charAt(index + 1) == ')')
                    {
                        count++;
                        index += 2;
                    }
                    else
                    {
                       count += 2;
                       index++;
                    }
                }
                else
                {
                    state--;
                    if(index + 1 < s.length() && s.charAt(index + 1) == ')')
                    {                       
                        index +=2;
                    }
                    else
                    {
                       count++;
                       index++;
                    }
                }
            
            }        
        }
       
        return count + 2 * state;
    }
}