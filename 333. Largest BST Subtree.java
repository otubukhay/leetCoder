 //333. Largest BST Subtree
 class Solution
    {
        int maxTree = 0;
        public int largestBSTSubtree(TreeNode root) 
		{
            findAll(root);
            return maxTree;
        }
		
        TreeInfo findAll(TreeNode root)
        {
            if(root == null)
            {
                return new TreeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }
			
            if(root.left == null && root.right == null)
            {
                maxTree = Math.max(maxTree, 1);
                return new TreeInfo(root.val, root.val, 1);
            }
			
            TreeInfo left = findAll(root.left);
            TreeInfo right = findAll(root.right);
          
			if(root.val > left.maxVal && root.val < right.minVal)
            {
                maxTree = Math.max(maxTree, left.count + right.count + 1);
                return new TreeInfo(Math.max(right.maxVal, root.val), Math.min(left.minVal, root.val), left.count + right.count + 1);
            }
            else
            {
                return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
        }
    }
	
    class TreeInfo
    {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int count = 0;

        public TreeInfo(int max, int min, int c)
        {
            maxVal = max;
            minVal = min;
            count = c;
        }
    }