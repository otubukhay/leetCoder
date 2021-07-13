    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        
        findMax(root, root.val, root.val);
        return max;
    }
    
    void findMax(TreeNode root, int minHere, int maxHere)
    {
        if(root == null)
            return;
        
        max = Math.max(Math.abs(minHere - root.val), Math.max(max, Math.abs(maxHere - root.val)));
        findMax(root.left, Math.min(root.val, minHere), Math.max(root.val, maxHere));
        findMax(root.right, Math.min(root.val, minHere), Math.max(root.val, maxHere));        
    }