    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0 )
            return -1;
        
        Stack<TreeNode> st = new Stack();
        TreeNode cur = root;
        
        while(!st.isEmpty() || cur != null)
        {
            if(cur != null)
            {                
                st.push(cur);
                cur = cur.left;
            }
            else
            {
                TreeNode top = st.pop();
                if(k == 1)
                    return top.val;   
                k--;
                cur = top.right;                
            }            
        }       
        
        return -1;
    }