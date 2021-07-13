 public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return check(root, sum);
    }
    
    
    private boolean check(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        
        return check(root.left, sum - root.val) || check(root.right, sum - root.val);
    }