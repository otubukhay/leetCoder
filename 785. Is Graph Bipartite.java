 public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0 ; i < colors.length; i++)
        {
            if(colors[i] != 0)
                continue;
            
            if(!canColor(i, graph, colors))
               return false;
        }
               
        return true;
    }
               
    boolean canColor(int i, int[][] graph, int[] colors)
    {
        Queue<Integer> q = new LinkedList();
        q.add(i);
        colors[i] = 1;
        
        while(!q.isEmpty())
        {            
            int cur = q.remove();
            for(int next : graph[cur])
            {
                if(colors[next] == colors[cur])
                    return false;
                
                if(colors[next] == 0)
                {
                   colors[next] = -colors[cur];
                   q.add(next);
                }
                
            }
            
        }
        
        return true;
        
    }