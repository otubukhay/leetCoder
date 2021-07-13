class NumArray {

        TreeNode root = null;
        private TreeNode buildTree(int[] nums, int start, int end) 
		{
            if (start > end) 
			{
                return null;
            }
			
            TreeNode res = new TreeNode(start, end);
            if (start == end) 
			{
                res.sum = nums[start];
            } 
			else 
			{
                int mid = start + (end - start) / 2;
                res.left = buildTree(nums, start, mid);
                res.right = buildTree(nums, mid + 1, end);
                res.sum = res.left.sum + res.right.sum;
            }

            return res;
        }

        public NumArray(int[] nums) 
		{
            root = buildTree(nums, 0, nums.length - 1);
        }

        private void update(TreeNode root, int i, int val) 
		{
            if (root.start == root.end) 
			{
                root.sum = val;
            } 
			else 
			{
                int mid = root.start + (root.end - root.start) / 2;
                if (i <= mid) 
				{
                    update(root.left, i, val);
                } 
				else 
				{
                    update(root.right, i, val);
                }

                root.sum = root.left.sum + root.right.sum;
            }
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        private int query(TreeNode root, int i, int j) {
            if (j == root.end && i == root.start) 
			{
                return root.sum;
            }
			else 
			{
                int mid = root.start + (root.end - root.start) / 2;
                if (j <= mid) 
				{
                    return query(root.left, i, j);
                }
				else if (i >= mid + 1) 
				{
                    return query(root.right, i, j);
                } 
				else 
				{
                    return query(root.left, i, mid) + query(root.right, mid + 1, j);
                }
            }
        }

        public int sumRange(int i, int j) {
            return query(root, i, j);
        }
    }

    class TreeNode {

        TreeNode left, right;
        int start, end;
        int sum;

        public TreeNode(int s, int e) {
            left = null;
            right = null;
            start = s;
            end = e;
        }
    }