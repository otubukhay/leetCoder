    public int findClosestLeaf(TreeNode root, int k)
    {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map, k);
        if (target == null) 
		{
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(target);
        visited.add(k);
        while (!queue.isEmpty()) 
		{
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null)
			{
                return cur.val;
            }
			
            if(cur.left != null && !visited.contains(cur.left.val)) 
			{
                queue.offer(cur.left);
                visited.add(cur.left.val);
            }
			
            if (cur.right != null && !visited.contains(cur.right.val)) 
			{
                queue.offer(cur.right);
                visited.add(cur.right.val);
            }
			
            if (map.containsKey(cur) && !visited.contains(map.get(cur).val)) 
			{
                queue.offer(map.get(cur));
                visited.add(map.get(cur).val);
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> map, int k)
    {
        if (root == null)
        {
            return;
        }
        if (parent != null)
        {
            map.put(root, parent);
        }

        if (root.val == k)
        {
            target = root;
        }

        dfs(root.left, root, map, k);
        dfs(root.right, root, map, k);
    }