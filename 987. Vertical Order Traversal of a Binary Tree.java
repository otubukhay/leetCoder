 public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) 
        {
            List<Integer> curList = new  ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) 
            {
                while (!nodes.isEmpty()) 
                {
                   curList.add(nodes.poll());
                }
            }
            
            result.add(curList);
        }
        return result;
    }
    
    private void dfs(TreeNode root, int col, int row, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map)
    {
        if (root == null) 
        {
            return;
        }
        
        if (!map.containsKey(col))
        {
            map.put(col, new TreeMap<>());
        }
        
        if (!map.get(col).containsKey(row)) 
        {
            map.get(col).put(row, new PriorityQueue<>());
        }
        
        map.get(col).get(row).offer(root.val);
        dfs(root.left, col - 1, row + 1, map);
        dfs(root.right, col + 1, row + 1, map);
    }