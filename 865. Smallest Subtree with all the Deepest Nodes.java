 //1123. Lowest Common Ancestor of Deepest Leaves
 public TreeNode subtreeWithAllDeepest(TreeNode root) 
    {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) 
    {
        if (node == null)
            return new Result(null, 0);
        
		Result left = dfs(node.left);
        Result right = dfs(node.right);
        
        if(left.dist == right.dist)
        {
            return new Result(node, left.dist + 1);
        }
        else
        {
            if (left.dist > right.dist) 
            {
                return new Result(left.node, left.dist + 1);
            }        
            else
            {
                return new Result(right.node, right.dist + 1);
            }            
        }        
        
    }