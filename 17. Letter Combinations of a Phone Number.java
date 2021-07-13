 //T, O(4 ^ N) * N, S,  O(N)
 
 /*
 Time complexity: O(4^N ) where N is the length of digits. 
 Note that 4 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra digit. 
Then, for each combination, it costs up to N to build the combination. This problem can be generalized to a scenario where numbers correspond 
with up to M digits, in which case the time complexity would be O(M^N * N). 
For the problem constraints, we're given, M = 4, because of digits 7 and 9 having 4 letters each.
 */
   public List<String> letterCombinations(String digits) 
    {
        if(digits == null || digits.length() == 0)
            return new ArrayList();
        
        List<String> ans = new ArrayList<String>();		
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		
        while(ans.get(0).length() < digits.length())
        {
			String remove = ans.remove(0);
			String map = mapping[digits.charAt(remove.length()) - '0'];
			for(char c: map.toCharArray())
            {
				ans.add(remove + c);
			}
		}
        
		return ans;        
    }
  