   //T, O(N * k ^2)
    class TrieNode 
	{
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> restIsPalindrome;
        TrieNode() {
            restIsPalindrome = new ArrayList<>();
        }
    }
    
    TrieNode root = new TrieNode();
    int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> palindromePairs(String[] words) 
    {
        n = words.length;        
        for (int i = 0; i < n; i++) {
            add(words[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            search(words[i], i);
        }
        
        return res;
    }
    
    private void search(String word, int wordIndex)
    {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) 
		{
            int j = chs[i] - 'a';
            if(cur.wordIndex != -1 && isPalindrome(chs, i, chs.length - 1)) 
            {
                res.add(Arrays.asList(wordIndex, cur.wordIndex));
            }
            
            if(cur.children[j] == null)
            {
                return;
            }
            
            cur = cur.children[j];
        }
        
        // aaaa
        if (cur.wordIndex != -1 && cur.wordIndex != wordIndex) 
        {
            res.add(Arrays.asList(wordIndex, cur.wordIndex));
        }
        
        for (int j : cur.restIsPalindrome)
        {
            res.add(Arrays.asList(wordIndex, j));
        }
    }
    
    private void add(String word, int wordIndex) 
    {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) 
        {
            int j = chs[i] - 'a';
            if (isPalindrome(chs, 0, i))
			{
                cur.restIsPalindrome.add(wordIndex);
            }
            
            if (cur.children[j] == null)
            {
                cur.children[j] = new TrieNode();
            }
            
            cur = cur.children[j];
        }
        
        cur.wordIndex = wordIndex;
    }
    
    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) return false;
        }
        
        return true;
	}

---------------------------------------------------------------------------------
private static boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = palindromePairs(strs);
        int n = 0;
    }

    private static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Returns the reversed string of the given string.
    private String reverseWord(String str) {
        // Leverage the existing library "StringBuilder" to reverse a string.
        return new StringBuilder(str).reverse().toString();
    }

    private Set<String> findPalindromesHelper(String word, Set<String> reversedWords) {
        Set<String> palindromes = new HashSet<>();
        if (reversedWords.contains(word)) {
            // Prevent forming a palindrome with a single word.
            String reversedWord = reverseWord(word);
            if (!reversedWord.equals(word)) {
                palindromes.add(word + reversedWord);
            }
        }
      
        for (int i = 1; i < word.length() - 1; i++) 
        {
            String takenOutStr = word.substring(word.length() - i);
            String remainingStr = word.substring(0, word.length() - i);
            if (isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)) 
            {
                String palindrome = remainingStr + takenOutStr + reverseWord(remainingStr);
                palindromes.add(palindrome);
            }
        }

        for (int i = 1; i < word.length() - 1; i++) 
        {
            String takenOutStr = word.substring(0, i);
            String remainingStr = word.substring(i);
            if (isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)) 
            {
                String palindrome = reverseWord(remainingStr) + takenOutStr + remainingStr;
                palindromes.add(palindrome);
            }
        }

        return palindromes;
    }

    Set<String> findPalindromes(List<String> words)
    {   // Reverse each word and put it in a set.
        Set<String> reversedWords = new HashSet<>();
        for (String word : words)
        {
            reversedWords.add(reverseWord(word));
        }

        // Iterate through each word and check if we can pair up with another
        // word to form a palindrome.
        Set<String> palindromes = new HashSet<>();
        for (String word : words) 
        {
            Set<String> palindromePairs = findPalindromesHelper(word, reversedWords);
            palindromes.addAll(palindromePairs);
        }

        return palindromes;
    }

-----------**(******************************************************************************
T = O(n ^ 2 * k)
class Solution 
{
    public List<List<Integer>> palindromePairs(String[] words) 
    {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) 
        {
            return ret;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) 
        {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) 
        {            
            for (int j = 0; j <= words[i].length(); j++) // notice it should be "j <= words[i].length()"
            { 
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)) 
                {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) 
                    {
                        ret.add(List.of(map.get(str2rvs),  i));                       
                    }
                }
                
                if (isPalindrome(str2)) 
                {
                    String str1rvs = new StringBuilder(str1).reverse().toString();                    
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) 
                    {  
                        ret.add(List.of(i, map.get(str1rvs)));         
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String str) 
    {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}