class Solution 
{    
    private int[][] adjMatrix;
    private HashMap<String, Long> memo;
    private Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {     
        this.adjMatrix = new int[n][n];
        this.memo = new HashMap<>();
        
        for (int[] flight: flights) 
        {
            this.adjMatrix[flight[0]][flight[1]] = flight[2];
            if(!graph.containsKey(flight[0]))
            {
                graph.put(flight[0], new HashMap<>());
            }
            
            if(!graph.get(flight[0]).containsKey(flight[1]))
            {
                graph.get(flight[0]).put(flight[1], flight[2]);    
            }
        }
            
        long ans = this.findShortest(src, K, dst, graph);
        return ans >= Integer.MAX_VALUE ? -1 : (int)ans;
    }
    
    public long findShortest(int start, int stops, int dst, Map<Integer, Map<Integer, Integer>> graph) 
    {       
        if (start == dst) 
        {
            return 0;
        }            
                
        if (stops < 0 || !graph.containsKey(start))
        {
            return Integer.MAX_VALUE;
        }
            
        String key = start + ", " + stops;       
        if (this.memo.containsKey(key)) 
        {
            return this.memo.get(key);
        }
              
        long ans = Integer.MAX_VALUE;
        for (Integer neighbour : graph.get(start).keySet())
        {            
            int weight = graph.get(start).get(neighbour);            
            long childDistance = this.findShortest(neighbour, stops - 1, dst, graph);
            if(childDistance != Integer.MAX_VALUE)
            {
               ans = Math.min(ans, childDistance + weight);            
            }
        } 
        
        // Cache the result
        this.memo.put(key, ans);
        return ans;
    }
}