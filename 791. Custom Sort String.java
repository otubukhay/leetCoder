class Solution {
  
    /*
        Use bucket sort to achieve linear time.
        Put string T into bucket;
        Scan each character of S and construct the result string using bucket;
        Scan bucket again to append the rest of characters which are not existing in string S.
        Actually, this problem has two follow up questions:
        Follow up 1: If the custom order S is too large, how to solve it efficiently?
        Follow up 2: If the string T is too large, how to solve it efficiently?
    */
 
    public String customSortString(String S, String T) 
    {
        int[] bucket = new int[26];
        for (char c : T.toCharArray())
        {
            bucket[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray())
        {
            for (int i = 0; i < bucket[c - 'a']; i++) 
            {
                sb.append(c);
            }
            
            bucket[c - 'a'] = 0;
        }
        
        for (int i = 0; i < 26; i++) 
            
            for (int j = 0; j < bucket[i]; j++) 
            {
                sb.append((char) (i + 'a'));
            }
        }
        
        return sb.toString();
    }
}