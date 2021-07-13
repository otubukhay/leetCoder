   //same AS 538. Convert BST to Greater Tree   
    int preSums = 0;
    public TreeNode bstToGst(TreeNode root)
    {
        setGreater(root);
        return root; 
    }
    
    public void setGreater(TreeNode root)
    {
        if(root == null)
            return;
               
        setGreater(root.right);        
        preSums = preSums + root.val;
        root.val = preSums;
        setGreater(root.left);
    }