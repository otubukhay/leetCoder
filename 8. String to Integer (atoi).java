 public int myAtoi(String str) 
    {
            int index = 0, sign = 1;
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
                int digit = str.charAt(index) - '0';
                if(digit < 0 || digit > 9) 
                    break;

                //check if total will be overflow after 10 times and add digit
                if(total > Integer.MAX_VALUE/10 || (digit > Integer.MAX_VALUE - 10 * total))
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

                total = 10 * total + digit;
                index ++;
            }
            return total * sign;
    }