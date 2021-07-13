    int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) 
    {
        if(root == null)
            return result;
        
        InOrder(root, L, R);
        return result;
    }    
    
    void InOrder(TreeNode root, int L, int R)
    {
         if(root == null)
            return;        
        
        if(root.val <= R && root.val >= L)
          result += root.val;   
        
        if(root.val > L)
          InOrder(root.left, L, R);   
             
        if(root.val < R)
          InOrder(root.right, L, R);        
    }