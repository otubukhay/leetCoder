 public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return depth(root);
    }
    
    private int  DFSdepth(TreeNode root){
        if(root == null)
            return 0;
        
        int left = DFSdepth(root.left);
        int right = DFSdepth(root.right);
        
        return Math.max(left, right) + 1;
    }

    private int  BFSdepth(TreeNode root){
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 1; i <= size; i++)
            {
                TreeNode current = q.poll();
                if(current.left != null)
                    q.offer(current.left);
                
                if(current.right != null)
                    q.offer(current.right);
            }
            
            level++;            
        }
        
        return level;        
    }