 public int myAtoi(String str) 
    {
            int index = 0;
            int sign = 1;
            int total = 0;           
            if(str.length() == 0) 
                return 0;          
           
            str = str.trim();
            if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
            {
               sign = str.charAt(index) == '-' ? -1 : 1;
               index++;
            }
            
            while(index < str.length())
            {                
                if(!Character.isDigit(str.charAt(index))) 
                    break;

                int digit = str.charAt(index) - '0';
                //check if total will be overflow after 10 times and add digit
                if(total > Integer.MAX_VALUE/10 || (digit > Integer.MAX_VALUE - 10 * total))
                {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                total = 10 * total + digit;
                index++;
            }
        
            return total * sign;
    }