 public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    
    TreeNode invert(TreeNode root){
        if(root == null)
            return null;
        
        TreeNode left  = invert(root.left);
        TreeNode right =  invert(root.right);
        
        root.left = right;
        root.right = left;
        return root;
    }