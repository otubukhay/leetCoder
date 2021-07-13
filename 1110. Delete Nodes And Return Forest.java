    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
	{
        if(root == null)
            return result;
        
        Set<Integer> set = new HashSet<>();
        for(int num : to_delete)
            set.add(num);
        
        delete(root, set);  
        if(!set.contains(root.val)) // root is a forest except it is to be deleted
         result.add(root);
       
	    return result;
    }
    
    TreeNode delete(TreeNode root, Set<Integer> set)
	{
        if(root == null)
            return null;
        
        root.left = delete(root.left, set);
        root.right = delete(root.right, set);
        
        if(set.contains(root.val)){
            
            if(root.left != null)
                result.add(root.left);
            
            if(root.right != null)
                result.add(root.right);            
            
            return null;
        }
        
        return root;
    }