    //O(h)
	//for a balanced tree
    //h = log(n)
	//hence o(h) = o(logn)
	double diff = Double.MAX_VALUE;
    int nodeVal = -1;
    public int closestValue(TreeNode root, double target) 
    {
         closest(root, target);
         return nodeVal;
    }

    public void closest(TreeNode root, double target) 
    {
          if(root == null)
            return;

          if(Math.abs(1.0 * root.val - target) < diff)
          {
              diff = Math.abs(1.0 * root.val - target);
              nodeVal = root.val;
          }

          if(target ==  root.val)
            return;

          if(root.val > target)
              closest(root.left, target);
          else
              closest(root.right, target);
    }