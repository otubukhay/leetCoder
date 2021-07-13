
/*
ADDWORD
Time complexity:O(M), where M is the word. At each step, we either examine or create a node in the trie. That takes only M operations.
Space complexity:O(M). In the worst-case newly inserted key doesn't share a prefix with the keys already inserted in the trie. We have to add MM new nodes, which takes O(M) space.
*/
/*
Time complexity: O(M) for the "well-defined" words without dots, where M is the key length, and N is a number of keys, and O(N* 26 ^ M) for the "undefined" words. 
That corresponds to the worst-case situation of searching an undefined word.
Space complexity: O(1) for the search of "well-defined" words without dots, and up to O(M) for the "undefined" words, to keep the recursion stack.
*/

class WordDictionary 
{
    class TrieNode
    {
       TrieNode[] children = new TrieNode[26];
       boolean isWord = false;
    }
    
    TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary()
    {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word)
    {
        TrieNode cur = root;
        for(char c : word.toCharArray())
        {
            int index = c - 'a';
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode();
            
            cur = cur.children[index];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) 
    {
        return find(root, 0, word);
    }
    
    private boolean find(TrieNode cur, int index, String word)
    {
        if(index >= word.length())
        {
            return cur.isWord;
        }
        
        char c = word.charAt(index);      
        if(c == '.')
        {            
            for(TrieNode child : cur.children)
            {                
                if(child != null &&  find(child, index + 1, word))
                {
                   return true;  
                }
            }
            
            return false;
        }
        else
        {
            return cur.children[c - 'a'] != null ? find(cur.children[c - 'a'], index + 1, word) : false;
        }        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 
 