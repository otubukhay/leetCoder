public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        path(root, "", result);        
        return result;
    }
    
    void path(TreeNode root, String cur, List<String> result){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
        {
            result.add(cur + String.valueOf(root.val));
            return;
        }
        
        path(root.left, cur + String.valueOf(root.val) + "->", result);
        path(root.right, cur + String.valueOf(root.val) + "->", result);
    }