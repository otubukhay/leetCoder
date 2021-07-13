    /*
	Complexity Analysis
	Time complexity : O(S), where S is the sum of all characters in all strings. 
	In the worst case there will be n equal strings with length m and the algorithm performs S = m * n character comparisons. 
	Even though the worst case is still the same as Approach 1, in the best case there are at most n \cdot minLen comparisons 
	where minLen is the length of the shortest string in the array.
	Space complexity : O(1). We only used constant extra space.
	*/
	
	public String longestCommonPrefix(String[] strs) 
    {
          if (strs == null || strs.length == 0)
		  { 
              return "";
		  }
		  
          for (int i = 0; i < strs[0].length() ; i++)
          {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j ++) 
                {
                    if (i == strs[j].length() || strs[j].charAt(i) != c)
					{
                        return strs[0].substring(0, i);             
					}
                }
            }
            return strs[0];
    }