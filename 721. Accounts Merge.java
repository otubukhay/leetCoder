//Time Complexity: O(∑ai * logai), where a_ia i is the length of accounts[i]. 
//Without the log factor, this is the complexity to build the graph and search for each component. The log factor is for sorting each component at the end.
  public List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
      
        buildGraph(accounts, graph, name);
       
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();        
        for (String email : name.keySet()) 
        {
            List<String> list = new LinkedList<>();
            if (!visited.contains(email)) 
            {               
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);                
            }
        }
        
        return res;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list)
    {
        list.add(email);
		visited.add(email);
        for(String next : graph.get(email)) 
        {
            if (!visited.contains(next)) 
            {               
                dfs(graph, next, visited, list);
            }
        }
    }
    
    public void buildGraph(List<List<String>> accounts, Map<String, Set<String>> graph, 
                           Map<String, String> name)
	{
          // Build the graph;
        for(List<String> account : accounts)
        {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) 
            {
                if (!graph.containsKey(account.get(i)))
                {
                    graph.put(account.get(i), new HashSet<>());
                }
                
                name.put(account.get(i), userName);                
                if (i > 1)
                {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }
        
    }    
    