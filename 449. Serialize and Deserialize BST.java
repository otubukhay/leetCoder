 public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb)
    {
        if (root == null) 
            return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if (data.isEmpty()) 
            return null;
        List<String> q = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(List<String> q, int lower, int upper)
    {
        if(q.isEmpty())
        { 
            return null;
        }
        
        int val = Integer.parseInt(q.get(0));
        if (val <= lower || val >= upper) 
        {
            return null;
        }
        
        q.remove(0);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
    }