    private static final int NOT_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    
    public boolean circularArrayLoop(int[] nums) 
    {
        int N = nums.length;
        int[] visited = new int[N];
        for(int i = 0; i < N; ++i)
        {
            if(visited[i] == NOT_VISITED && dfs(i, visited, nums)) 
                return true;
        }
        
        return false;
    }
    
    private boolean dfs(int cur, int[] visited, int[] nums)
    {
        int N = nums.length;
        if(visited[cur] == VISITING) 
            return true;
        if(visited[cur] == VISITED) 
            return false;
        
        visited[cur] = VISITING;
        
        int next = cur + nums[cur];
        next %= N;
        if(next < 0) 
            next += N;
        
        // not a valid cycle if the length is 1
        // not a valid cycle if coming from different directions
        if(next == cur || nums[next] * nums[cur] < 0)
        {
            visited[cur] = VISITED;
            return false;
        }
        
        if(dfs(next, visited, nums))
            return true;
       
        visited[cur] = VISITED;
        return false;
    }