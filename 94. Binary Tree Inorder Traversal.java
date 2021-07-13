 public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        
        Stack<TreeNode> st = new Stack();
        TreeNode cur =  root;
        
        while(cur != null || !st.isEmpty())
        {
            if(cur != null)
            {
                st.push(cur);
                cur = cur.left;                
            }            
            else
            {
                TreeNode temp = st.pop();
                list.add(temp.val);
                cur = temp.right;
            }            
        }
        
        return list;
    }