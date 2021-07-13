    public boolean isValidBST(TreeNode root)
	{
        return Valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
        
    private boolean Valid(TreeNode root, long lowest, long highest){
        if(root == null)
            return true;
        
        if(root.val <= lowest  || root.val >= highest)
            return false;
        
        return Valid(root.left, lowest, root.val)
            && Valid(root.right, root.val, highest);
        
    }