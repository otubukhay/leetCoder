 public int calculate(String s)
     {         
        s = s.trim();
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';                 
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if(c != ' ')
            {
                if(Character.isDigit(c)) 
                    num = num * 10 + c - '0';
            
                if(i == s.length() - 1 || !Character.isDigit(c)) 
                {
                    switch(lastSign) 
                    {
                        case '+':
                            sum += tempSum;
                            tempSum = num;
                            break;
                        case '-':
                            sum += tempSum;
                            tempSum = -num;
                            break;
                        case '*':
                            tempSum *= num;
                            break;
                        case '/':
                            tempSum /= num;
                            break;
                    }

                    lastSign = c;
                    num = 0;
                }
            }
            
        }         
        
        return sum + tempSum;
    }