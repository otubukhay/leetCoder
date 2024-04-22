class Solution {
     public List<List<Integer>> verticalOrder(TreeNode root)
  {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) 
			return res;
        Map<Integer, List<Integer>> map = new HashMap<>(); // Using treemap with cause look up to logn, hence solution nlogn
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> code = new LinkedList<>();

        queue.offer(root);
        code.offer(0);

        int min = 0; //use min/max to keep track of smallest and highest window
        int max = 0;
        while(!queue.isEmpty())
	{
            TreeNode front = queue.poll();
            int val = code.poll();
            map.putIfAbsent(val, new ArrayList<>());			
            map.get(val).add(front.val);
            
            if(front.left != null)
	    {
                queue.offer(front.left);
                code.offer(val - 1);
                min = Math.min(min, val - 1);
            }
			
           if(front.right != null)
	   {
                queue.offer(front.right);
                code.offer(val + 1);
                max = Math.max(max, val + 1);
            }
        }
      
        for (int i = min; i <= max; i++) {
           res.add(map.get(i));
        }
        return res;      
    }
}

