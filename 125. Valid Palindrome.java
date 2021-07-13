//O(n)
public boolean isPalindrome(String s) 
    {
        if(s == null)
            return false;
        if(s.length() == 0)
            return true;
        
        int len = s.length();
        int low = 0;
        int high = len - 1;     
        s = s.toLowerCase();
        
        while(low <= high)
        {            
            while(low < high && !Character.isLetterOrDigit(s.charAt(low)))
                 low++;
            
            while(low < high && !Character.isLetterOrDigit(s.charAt(high)))
                 high--;
            
            if(s.charAt(low) != s.charAt(high))
                return false;    
            
            low++;
            high--;            
        }
        
      
        return true;
    }