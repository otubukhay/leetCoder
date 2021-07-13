    /*	
		Let N be the total number of strings in the input list.
		Let C be the total length of all the words in the input list, added together.
		Let U be the total number of unique letters in the alien alphabet. 
		While this is limited to 26 in the question description, 
		we'll still look at how it would impact the complexity if it was not limited (as this could potentially be a follow-up question).

		Time complexity : O(C).
	*/
	public String alienOrder(String[] words) 
    { 
        Map<Character, List<Character>> graph = new HashMap<>(); 
        Map<Character, Integer> indegree = new HashMap<>(); 
        buildMap(words, graph, indegree);
        String sort = bfs(graph, indegree); 
        return sort.length() < indegree.size() ? "" : sort; 
    }
    
    void buildMap(String[] words, Map<Character, List<Character>> adjList, Map<Character, Integer> counts)
    {
        //Add all characters
        for (String word : words)
        {
            for (char c : word.toCharArray())
            { 
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        // Step 1: Find all edges.
       for (int i = 0; i < words.length - 1; i++)
       {
           String word1 = words[i];
           String word2 = words[i + 1]; // Check that word2 is not a prefix of word1.
           if (word1.length() > word2.length() && word1.startsWith(word2))
           {
               counts.clear();
               return;
           }
           // Find the first non match and insert the corresponding relation.
           for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
           {
				 if (word1.charAt(j) != word2.charAt(j))
				 {
					 adjList.get(word1.charAt(j)).add(word2.charAt(j));
					 counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
					 break;
				 }
           }
       }

    }
    
    private String bfs(Map<Character, List<Character>> adjList, Map<Character, Integer> counts)
    { // Step 2: Breadth-first search.
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet())
        {
            if (counts.get(c).equals(0))
            {
                queue.add(c); 
				sb.append(c);
            }
        }

        while (!queue.isEmpty())
        {
            Character c = queue.remove();
            for (Character next : adjList.get(c))
            {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0))
                {
                    queue.add(next); 
					sb.append(next);
                }
            }
        }
        return sb.toString();
    }
