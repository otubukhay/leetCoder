class Solution 
{
    int[] distance, count;
    List<Set<Integer>> graph;
    int N;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) 
    {
        this.N = N;
        graph = new ArrayList<Set<Integer>>();
        distance = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
        {
            graph.add(new HashSet<Integer>());
        }
        
        for (int[] edge: edges) 
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1);
        return distance;
    }

    public void postOrder(int node, int parent)
    {
        for (int child: graph.get(node))
        {
            if (child != parent) 
            {
                postOrder(child, node);
                count[node] += count[child];
                distance[node] += distance[child] + count[child];
            }
        }
    }

    public void preOrder(int node, int parent)
    {
        for (int child: graph.get(node))
        {
            if (child != parent) 
            {
                distance[child] = distance[node] - count[child] + N - count[child];
                preOrder(child, node);
            }
        }
    }
}
