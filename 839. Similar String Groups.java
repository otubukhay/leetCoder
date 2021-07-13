    public int numSimilarGroups(String[] A) 
    {
        Map<String, Set<String>> g = new HashMap<>();
        buildGraph(A, g);
                
        int count = 0;
        Set<String> visited = new HashSet<>();
        for(String key : g.keySet()) 
        {
            if(!visited.contains(key)) 
            {
                dfs(visited, key, g);
                count++; 
            }          
        }

        return count;
    }

    private void dfs(Set<String> visited, String cur, Map<String, Set<String>> g) 
    {
        visited.add(cur);
        if(g.get(cur).size() == 0) 
            return;
        for(String next : g.get(cur))
        {
            if (!visited.contains(next)) 
            {
               dfs(visited, next, g);     
            }               
        }
    }

    private void buildGraph(String[] A, Map<String, Set<String>> g)
    {
        for(String s : A) 
        {
            g.put(s, new HashSet<>());
        }

        int n = A.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (isSimilar(A[i], A[j])) 
                {
                    g.get(A[i]).add(A[j]);
                    g.get(A[j]).add(A[i]);
                }
            }
        }
    }

    private boolean isSimilar(String a, String b) 
    {        
        int len = a.length();
        int diff = 0;
        for (int i = 0; i < len; i++) 
        {
            if (a.charAt(i) != b.charAt(i)) 
            {
                diff++;
                if (diff > 2) return false;
            }
        }

        return true;
    }