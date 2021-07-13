 public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        
        if (root == null) 
            return r;
        
        Queue<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        TreeNode cur = null;
        int sizel = 0;
        
        while (!dq.isEmpty()) 
        {
            int size = dq.size();           
            for (int i = 1; i <= size; ++i) 
            {
                cur = dq.remove();
                if(i == size)
                {
                    r.add(cur.val);
                }
                
                if(cur.left != null) 
                {
                    dq.add(cur.left);
                }
                
                if(cur.right != null) 
                {
                    dq.add(cur.right);  
                }
            }
            
           
        }
        return r;
    }