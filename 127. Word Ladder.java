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
                        if(temp !=c)
                        {
                            arr[i] = c;                
                            String newWord = new String(arr);
                            if(wordDict.contains(newWord))
                            {
                                queue.add(newWord);
                                wordDict.remove(newWord);
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