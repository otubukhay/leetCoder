 /*
 Time complexity : O(N) in the best case of k distinct characters in the string and O(Nk) in the worst case of N distinct characters in the string.
 Space complexity : O(k) since additional space is used only for a hashmap with at most k + 1 elements.
 */
 public int lengthOfLongestSubstringKDistinct(String s, int k) 
 {
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int start = 0;
    
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
    
            while(map.size() > k)
            {
                char t = s.charAt(start);                
                map.put(t,  map.get(t) - 1);
                if(map.get(t) == 0)
                {
                    map.remove(t);
                }
                
                start++;
            }	
            
            max = Math.max(max, i - start + 1);
        } 
        
        return max;	
 }