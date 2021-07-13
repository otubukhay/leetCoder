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
  