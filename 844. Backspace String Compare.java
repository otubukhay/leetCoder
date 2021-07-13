public boolean backspaceCompare(String S, String T) {
         return build(S).equals(build(T));
    }
    
     public String build(String S) {
        int count = 0;
        StringBuilder b = new StringBuilder();
        char[] arr = S.toCharArray();
        for (int i = arr.length - 1 ;i >= 0; i--) 
        {
            char c = arr[i];
            if (c == '#')
            {
               count++;
            }
            else
            { 
                if(count > 0)
                {
                   count--;
                }
                else
                {
                    b.append(c);
                }
            }
        }
         
        return b.toString();
    }