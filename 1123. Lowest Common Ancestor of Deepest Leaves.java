    public TreeNode lcaDeepestLeaves(TreeNode root) 
	{
        return root == null ? null :  dfs(root).node;
    }
    
    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) 
    {
        if (node == null)
            return new Result(null, 0);
        Result L = dfs(node.left);
        Result R = dfs(node.right);
        
        if(L.dist == R.dist)
        {
            return new Result(node, L.dist + 1);
        }
        else
        {
            if (L.dist > R.dist) 
            {
                return new Result(L.node, L.dist + 1);
            }        
            else
            {
                return new Result(R.node, R.dist + 1);
            }            
        }        
        
    }


    class Result
    {
        TreeNode node;
        int dist;
        Result(TreeNode n, int d)
        {
            node = n;
            dist = d;
        }
    }