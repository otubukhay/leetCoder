   public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
       return getAllElementsV2(root1, root2);
    }    
    
     public List<Integer> getAllElementsV2(TreeNode root1, TreeNode root2) 
     {      
         List<Integer> sortedOne = new ArrayList();
         sortList(root1, sortedOne);
         
         List<Integer> sortedTwo = new ArrayList();
         sortList(root2, sortedTwo);
         
         int m = sortedOne.size(), i = 0;
         int n = sortedTwo.size(), j = 0;
         
         List<Integer> result = new ArrayList();
         while(i < m  ||  j < n)
         {
            int oneVal = i < m ?  sortedOne.get(i) : Integer.MAX_VALUE;
            int twoVal = j < n ?  sortedTwo.get(j) : Integer.MAX_VALUE;
             
            if(oneVal <=  twoVal)
            {
                result.add(oneVal);
                i++;
            }
            else
            {
                result.add(twoVal);
                j++;
            }
         }
         
         return result;         
     }
    
    
    void sortList(TreeNode root, List<Integer> cur)
    {
        if(root == null)    
            return ;
        sortList(root.left, cur);
        cur.add(root.val);
        sortList(root.right, cur);
	}
	
	---------------------------------------------------------------------------------------------
	List<Integer> withControlledStack(TreeNode root1, TreeNode root2)
    {       
        Stack<TreeNode> first = new Stack<>();   
        traverseLeft(first, root1);
        
        Stack<TreeNode> second =  new Stack<>();   
        traverseLeft(second, root2);
        
        List<Integer> result = new ArrayList();
        while(!first.isEmpty() || !second.isEmpty())
        {
            int firstVal  = first.isEmpty() ? Integer.MAX_VALUE : first.peek().val;
            int secondVal = second.isEmpty() ? Integer.MAX_VALUE : second.peek().val;
            
            if(firstVal <= secondVal)
            {      
               result.add(firstVal);
               traverseLeft(first, first.pop().right);               
            }
            else
            {
               result.add(secondVal);              
               traverseLeft(second, second.pop().right);               
            }
        }
        
        return result;        
    }
    
	void traverseLeft(Stack<TreeNode> stack, TreeNode root)
    {        
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }        
    }