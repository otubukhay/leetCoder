    Map<Integer, Integer> inorderIndexMap;    
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) 
        {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    
    private TreeNode arrayToTree(int inOrderStart, int inOrderEnd, int[] postorder, 
                                 int postOrderStart, int postOrderEnd)
    {
        if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd) 
            return null;
        
        TreeNode root = new TreeNode(postorder[postOrderEnd]);
        int index = inorderIndexMap.get(postorder[postOrderEnd]);       
        root.left = arrayToTree(inOrderStart, index - 1, postorder, postOrderStart, postOrderStart + index - inOrderStart - 1);
        root.right = arrayToTree(index + 1, inOrderEnd, postorder, postOrderStart + index - inOrderStart, postOrderEnd - 1);
        return root;
    }
    