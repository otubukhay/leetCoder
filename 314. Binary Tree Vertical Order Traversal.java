  public List<List<Integer>> verticalOrder(TreeNode root)
  {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) 
			return res;
        Map<Integer, List<Integer>> dict = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> code = new LinkedList<>();

        queue.offer(root);
        code.offer(0);
        while(!queue.isEmpty())
		{
            TreeNode front = queue.poll();
            int val = code.poll();
            if(!dict.containsKey(val))
			{
                dict.put(val, new ArrayList<>());
            }
			
            dict.get(val).add(front.val);
            if(front.left != null)
			{
                queue.offer(front.left);
                code.offer(val - 1);
            }
			
            if(front.right != null)
			{
                queue.offer(front.right);
                code.offer(val + 1);
            }
        }
        res.addAll(dict.values());
        return res;

    }