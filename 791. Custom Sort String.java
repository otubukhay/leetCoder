  /*
        Use bucket sort to achieve linear time.
        Put string T into bucket;
        Scan each character of S and construct the result string using bucket;
        Scan bucket again to append the rest of characters which are not existing in string S.
        Actually, this problem has two follow up questions:
        Follow up 1: If the custom order S is too large, how to solve it efficiently?
        Follow up 2: If the string T is too large, how to solve it efficiently?
		
		How to solve this with optimized way?.
		Time Complexity: O(S.length+T.length), the time it takes to iterate through S and T
		Space Complexity: O(T.length). We count at most 26 different lowercase letters, but the final answer has the same length as T.
    */
 
    public String customSortString(String S, String T) 
    {
        int[] bucket = new int[26];
		// Group string T to be sorted in a bucket by count
        for (char c : T.toCharArray()) 
        {
            bucket[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
		//Go through each char in order String S, get count needed 
        for (char c : S.toCharArray())
        {
            for (int i = 0; i < bucket[c - 'a']; i++) 
            {
                sb.append(c);
            }
            
            bucket[c - 'a'] = 0;
        }
        
       for (char c ='a'; c <='z'; c++)
        {            
            for (int j = 0; j < bucket[c - 'a']; j++) 
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }