//O(log 10(n))
 public boolean isPalindrome(int x) 
    {
        if(x < 0 || (x % 10 == 0 && x != 0)) 
        {
            return false;
        }
        
        if(x == 0)
            return true;

        int revertedNumber = 0;
        int cur = x;
        while(x > revertedNumber) 
        {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        return x == revertedNumber || x == revertedNumber/10;
    }
    