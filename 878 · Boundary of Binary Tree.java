     /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
          return result;

        result.add(root.val);
        traverseLeft(root.left, result);
        traverseLeaves(root.left, result);
        traverseLeaves(root.right, result);
        traverseRight(root.right, result);

        return result;
    }

    void traverseLeft(TreeNode root, List<Integer> result)
    {
        if(root == null || (root.left == null && root.right == null))
            return;
       
        result.add(root.val);
        if(root.left != null)
        {
            traverseLeft(root.left, result);  
        }
        else
        {
            traverseLeft(root.right, result);
        }
    }

    void traverseRight(TreeNode root, List<Integer> result)
    {
        if(root == null || (root.left == null && root.right == null))
            return;
                
        if(root.right != null)
        {
            traverseRight(root.right, result);  
        }
        else
        {
            traverseRight(root.left, result);
        }

        result.add(root.val);
    }

    void traverseLeaves(TreeNode root, List<Integer> result)
    {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
          result.add(root.val);

        traverseLeaves(root.left, result);  
        traverseLeaves(root.right, result);
    }