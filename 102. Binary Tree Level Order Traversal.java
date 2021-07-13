 public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);       
          
        while(!q.isEmpty())
        {
           int size = q.size();
           List<Integer> curList = new ArrayList<>();
            
           for(int i = 1; i <= size; i++)
           {
                TreeNode cur = q.remove();
                curList.add(cur.val);
              
                if(cur.left!=null)
                {
                   q.add(cur.left);                               
                }

                if(cur.right != null)
                {
                   q.add(cur.right);                 
                }
           }
            
            res.add(curList);                
        }
        
        return res;
    }