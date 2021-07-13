 int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        findMax(root);        
        return max;
    }
    
    int findMax(TreeNode root)
    {
        if(root == null)     
           return -1;          
        
        int left = findMax(root.left);
        int right = findMax(root.right);
        
        int maxChild = Math.max(root.val, Math.max(root.val + left, root.val + right));
        
        max = Math.max(max, Math.max(maxChild, left + root.val + right));        
        return maxChild;
    }