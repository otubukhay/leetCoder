int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root == null)
           return 0;
                
        findDiameter(root);        
        return diameter;        
    }
    
    private int findDiameter(TreeNode root){
        if(root == null)
            return 0;
        
        int left =  findDiameter(root.left);
        int right = findDiameter(root.right);
        
        diameter = Math.max(diameter, left + right);        
        return  1 + Math.max(left, right);
	}