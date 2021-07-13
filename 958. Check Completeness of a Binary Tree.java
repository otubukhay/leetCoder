
     public boolean isCompleteTree(TreeNode root) 
     {
        boolean nullSeen = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) 
        {
            TreeNode cur = queue.poll();
            if(cur != null)
            {
                if(nullSeen) 
                {
                   return false;
                }
                
                queue.add(cur.left);
                queue.add(cur.right);                
            }
            else
            {
                nullSeen = true;
            }
        }
         
        return true;
    }