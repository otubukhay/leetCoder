 public int minDeletions(String s) 
    {
        int[] count = new int[26];
        int deletions = 0;
        Set<Integer> used = new HashSet<>();        
        for (int i = 0; i < s.length(); ++i)
        {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; ++i)
        {
            int freq = count[i];
            while (freq > 0 && used.contains(freq)) 
            {               
                --freq;
                ++deletions;
            }
            
            used.add(freq);
        }     
        
        return deletions;
    }