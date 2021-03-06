public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {        
        return merge(t1, t2);
    }
    
     public TreeNode merge(TreeNode t1, TreeNode t2) {        
        if(t1 == null || t2 == null) 
            return t2 == null ? t1 : t2;        
         
        TreeNode root = new TreeNode(t1.val + t2.val);        
        root.left = merge(t1.left, t2.left);
        root.right = merge(t1.right, t2.right);
         
        return root;
     }