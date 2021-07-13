 public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2; // union
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {

        while (roots[id] != id) {
            roots[id] = roots[roots[id]]; // optional: path compression
            id = roots[id];
        }
        return id;
    }
*************************************************************************************
    public int countComponentsDFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int[] e : edges) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new ArrayList());
            }
            if (!graph.containsKey(e[1])) {
                graph.put(e[1], new ArrayList());
            }
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
		
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    public void dfs(Integer i, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        if (graph.containsKey(i)) {
            for (int child : graph.get(i)) {
                if (!visited[child]) {
                    dfs(child, graph, visited);
                }
            }

        }
    }
