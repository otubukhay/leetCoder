class Solution 
{
    int count = 0;
    public int countSubstrings(String s) 
    {
        if(s.length() == 0)
            return 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            countAll(i, i, s);
            countAll(i, i + 1, s);
        }
        
        return count;
    }
    
    void countAll(int lo, int hi, String s)
    {
        while(lo >= 0 && hi < s.length() && s.charAt(lo) ==  s.charAt(hi))
        {
             lo--;
             hi++;
             count++;
        }    
    }
}
