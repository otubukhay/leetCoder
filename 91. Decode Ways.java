    public int numDecodings(String s) 
    {
       if(s == null || s.length() == 0)
            return 0;
        
        int n = s.length();
        int last = 1;
        int secondLast = s.charAt(n - 1) == '0' ? 0 : 1;        
        for(int i = n - 2; i >=0 ; i--)
        {
            char curChar = s.charAt(i);
            if(curChar == '0')
            {
                last = secondLast;
                secondLast = 0;
            }
            else
            {
              int val = Integer.parseInt(s.substring(i, i + 2));
              int temp = (val <= 26) ? last + secondLast : secondLast;
              last = secondLast;
              secondLast = temp;                                 
            }
        }
        
        
        return secondLast;
    }