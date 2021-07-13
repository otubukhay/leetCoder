 public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length -1, inorder, 0 , inorder.length-1);
    }
    
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
        {
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);
        
        int k = find(inorder, val);
        p.left = construct(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k + 1 , inEnd);

        return p;
    }
    
    int find(int[] inorder, int val){
        int k = 0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
               return i;
            }
        }   
        return k;
       
    }