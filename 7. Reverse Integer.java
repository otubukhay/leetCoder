 public int reverse(int x)
    {
        int sign = x < 0 ? -1 : 1;
        int result = 0;
        
        x = Math.abs(x);
        while(x != 0)
        {           
            if(result > Integer.MAX_VALUE/10 || (x % 10) > Integer.MAX_VALUE - 10 * result) 
                return 0;
            result = (result * 10) + (x % 10);
            x = x/10;
        }
        return sign * result;
    }