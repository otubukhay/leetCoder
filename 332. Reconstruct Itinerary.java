    /*
	Just Eulerian path. Greedy DFS, building the route backwards when retreating.
	More explanation and example under the codes.
	*/
	public List<String> findItinerary(List<List<String>> tickets)
    {        
        List<String> itinerary = new LinkedList<String>();
        HashMap<String, PriorityQueue<String>> graph = buildMap(tickets);
        dfs(graph, itinerary, "JFK");
        
        Collections.reverse(itinerary);
        return itinerary;
    }
    
    
     private void dfs(HashMap<String, PriorityQueue<String>> graph, 
            List<String> itinerary, String origin) 
     {
        PriorityQueue<String> destinations = graph.get(origin);
        if (destinations != null) 
		{
            while (!destinations.isEmpty()) 
            {
                dfs(graph, itinerary, destinations.poll());
            }
        }
         
        itinerary.add(origin);
    }
    
    private HashMap<String, PriorityQueue<String>> buildMap(List<List<String>> tickets)
    {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) 
        {
            String origin = ticket.get(0);
            String destination = ticket.get(1);
            if (graph.get(origin) == null) 
            {
                graph.put(origin, new PriorityQueue<String>());
            }
            
            graph.get(origin).offer(destination);
        }
        
        return graph;
    }