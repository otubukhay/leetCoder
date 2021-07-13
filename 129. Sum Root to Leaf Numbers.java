    int sum = 0;
    public int sumNumbers(TreeNode root) 
    {
        addAll(root, 0);
        return sum;
    }
    
    private void addAll(TreeNode root, int cur)
    {
        if(root == null)
            return;
        
        int newVal = 10 * cur + root.val;
        if(root.left == null && root.right == null)
        {
            sum += newVal;
        }
        else
        {   
           addAll(root.left, newVal);
           addAll(root.right, newVal);
        }
    }