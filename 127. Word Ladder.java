/*
Complexity Analysis

Time Complexity: O(M ^ 2×N), where M is the length of each word and N is the total number of words in the input word list.
For each word in the word list, we iterate over its length to find all the intermediate words corresponding to it. 
Since the length of each word is M and we have N words, the total number of iterations the algorithm takes to create all_combo_dict is M×N. 
Additionally, forming each of the intermediate word takes O(M)O(M) time because of the substring operation used to create the new string. 
This adds up to a complexity of O(M ^ 2 ×N).

Breadth first search in the worst case might go to each of the NN words. 
For each word, we need to examine M possible intermediate words/combinations. Notice, we have used the substring operation to find each of the combination. 
Thus, M combinations take O(M ^ 2 ) time. As a result, the time complexity of BFS traversal would also be O(M ^ 2×N).
*/ 
 public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(beginWord);       
        
        Set<String> wordDict = new HashSet<String>(wordList);
        if(!wordDict.contains(endWord))
            return 0;
                
        int distance = 1;
        while(!queue.isEmpty())
        { 
            int size  = queue.size();             
            for(int count = 1; count <= size; count++)
            {
                String word = queue.remove();          
                if(word.equals(endWord))
                {
                    return distance;
                } 
            
                char[] arr = word.toCharArray();
                for(int i = 0; i < arr.length; i++)
                {
                    for(char c ='a'; c <='z'; c++)
                    {
                        char temp = arr[i];
                        if(temp != c)
                        {
                            arr[i] = c;                
                            String newWord = new String(arr);
                            if(wordDict.contains(newWord))
                            {
                                queue.add(newWord);
                                wordDict.remove(newWord); // ensures we wont find this word again; If not removed used visited set

                            }
                            
                            arr[i] = temp;
                         }
                    }
                }                
            }
            
            distance++;
        }
 
        return 0;
    }