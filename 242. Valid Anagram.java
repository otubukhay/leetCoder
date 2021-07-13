  public boolean isAnagram(String s, String t)
  {
        if (s.length() != t.length()) 
        {
           return false;
        }
        
        int[] used = new int[26];      
        for (int i = 0; i < s.length(); i++)
        {
            used[s.charAt(i) - 'a'] += 1;
            used[t.charAt(i) - 'a'] -= 1;
        }
        
        for(int i = 0; i < used.length;i++)
        {
            if(used[i] != 0)
                return false;
        }
        
        return true;
    }