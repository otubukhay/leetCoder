public class BSTIterator 
    {
        Stack<TreeNode> s = new Stack<>();
        public BSTIterator(TreeNode root)
        {
            while(root != null){
                s.push(root);
                root = root.left;
            }
        }
        /** @return the next smallest number */
        public int next() {
            if(s.isEmpty())
                return -1;
            TreeNode cur = s.pop();
            int val = cur.val;
            TreeNode right = cur.right;
            while(right != null)
            {
                s.push(right);
                right = right.left;
            }
            return val;
        }
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !s.isEmpty();
        }