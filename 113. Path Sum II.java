 public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
       
        dfs(root, new ArrayList(), result, sum);        
        return result;
    }
    
    void dfs(TreeNode root, List<Integer> cur, List<List<Integer>> result, int sum)
    {
        if(root == null)
            return;
        
        List<Integer> ret = new ArrayList(cur);
        ret.add(root.val);
        
        if(root.left == null && root.right == null)
        {            
            if(root.val == sum)
            {
                result.add(new ArrayList(ret));
            }           
         
        }   
        else
        {             
            dfs(root.left, ret, result, sum - root.val);
            dfs(root.right, ret, result, sum - root.val);
        }      
    }