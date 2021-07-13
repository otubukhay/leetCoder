    StringBuilder b = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root == null) 
            return null;
        
        Serialize(root);        
        return b.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data == null)
            return null;
        
        return buildTree(data.split(","), new int[1]);
    }
    
    private void Serialize(TreeNode root)
    {
        if(root == null)
        {
            b.append("#,");
            return;
        }
        
        b.append(root.val + ",");
        Serialize(root.left);
        Serialize(root.right);
    }
    
    private TreeNode buildTree(String[] data, int[] index)
    {
        
        if(index[0] >= data.length || "#".equals(data[index[0]])){
            index[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(data[index[0]]));
        index[0]++;
        root.left = buildTree(data, index);        
        root.right = buildTree(data, index);
        
        return root;
    }