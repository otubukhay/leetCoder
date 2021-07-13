class Solution {
    boolean strmatch(String t, String p, 
                                 int n, int m) 
    { 
        boolean T[][] = new boolean[n + 1][m + 1];
        T[0][0] = true;
        char[] text = t.toCharArray();
        char[] pattern = p.toCharArray();
        
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) 
        {
            if (pattern[i - 1] == '*') 
            {
                T[0][i] = T[0][i - 2];
            }
        }
        
        
        for (int i = 1; i < T.length; i++) 
        {
            for (int j = 1; j < T[0].length; j++) 
            {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) 
                {
                    T[i][j] = T[i - 1][j - 1];
                } 
                else if (pattern[j - 1] == '*') 
                {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) 
                    {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } 
                else 
                {
                    T[i][j] = false;
                }
            }
        }
        
        return T[text.length][pattern.length];
    } 
    
    public boolean isMatch(String s, String p) {
       return strmatch(s, p, s.length(), p.length());
    }
}