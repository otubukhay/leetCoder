class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)
           return true;
           
        int lo = 0;
        int hi = s.length() - 1;
        
        while(lo < hi)
        {
            if(s.charAt(lo) != s.charAt(hi))
            {
                return isPali(s, lo, hi - 1)  || isPali(s,  lo + 1, hi);
            }
            
            lo++;
            hi--;
        }
           
        return true;
    
   }
           
    boolean isPali(String s, int lo, int hi)
    {
        while(lo < hi)
        {
             if(s.charAt(lo) != s.charAt(hi))
                 return false;
            
             lo++;
             hi--;
        }
        
        return true;
    }
}
           