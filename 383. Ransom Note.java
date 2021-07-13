public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] has = new int[26];
        for(char c : magazine.toCharArray())
        {
            has[c - 'a']++;
        }
        
        for(char c : ransomNote.toCharArray())
        {
            if(has[c - 'a'] <= 0)
                return false;
            
            has[c - 'a']--;
        }
        return true;
    }