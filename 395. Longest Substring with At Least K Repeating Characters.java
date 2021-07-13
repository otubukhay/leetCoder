   //Partition O(n2)   
   int longestSubstring(String s, int left, int right, int k)
    {       
        int[] counters = new int[26];
        for(int i = left; i <= right; i++)
        {
            counters[s.charAt(i) -'a']++;
        }        
        
        for(int mid = left; mid <= right; mid++)
        {
            if(counters[s.charAt(mid) -'a'] < k)
            {
                return Math.max(longestSubstring(s, left, mid - 1, k), longestSubstring(s, mid + 1, right, k)); 
            }
        }
        
        return right - left + 1;
    }
	
**************************************************************************************************************************************************************
    O(n)
**************************************************************************************************************************************************************
    public int longestSubstring(String s, int k)
    {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getCountUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) 
        {
            result = Math.max(slidingWindow(s, currUnique, k) , result);
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getCountUniqueLetters(String s)
    {
        boolean map[] = new boolean[26];
        int uniqueCount = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            if (!map[s.charAt(i) - 'a']) 
            {
                uniqueCount++;
                map[s.charAt(i) - 'a'] = true;
            }
        }       
        return uniqueCount;
    }
    
    int slidingWindow(String s, int num, int k) 
    {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int result = 0;
        while(right < s.length()) 
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > num)
            {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);                   
                if(map.get(s.charAt(left)) == 0) 
                {
                    map.remove(s.charAt(left));
                }

                left++;
            }

            int match = 0;
            for(int cur : map.values()) 
            {
                if(cur >= k)
                {
                    match++;
                }
            }

            result = match == map.size() ? Math.max(result, right - left + 1) : result;
            right++;
        }

        return result;
    }