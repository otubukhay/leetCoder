public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
     if(root == null)
        return res;                 
    
    Stack<TreeNode> currentLevel = new Stack<>(); 
    Stack<TreeNode> nextLevel = new Stack<>();   
    
    currentLevel.push(root); 
    boolean leftToRight = true; 
  
    List<Integer> ls = new ArrayList<>();
    while (!currentLevel.isEmpty()) 
    {   
         int size = currentLevel.size();
         for(int i = 1; i <= size; i++)
         {
             
            TreeNode node = currentLevel.pop(); 
            ls.add(node.val) ;

            if (leftToRight) 
            { 
                if (node.left != null) 
                { 
                    nextLevel.push(node.left); 
                } 

                if (node.right != null) 
                { 
                    nextLevel.push(node.right); 
                } 
            } 
            else 
            { 
                if (node.right != null) 
                { 
                    nextLevel.push(node.right); 
                } 

                if (node.left != null) 
                { 
                    nextLevel.push(node.left); 
                } 
            } 
           
         }
        
          leftToRight = !leftToRight;                 
          currentLevel = nextLevel; 
          nextLevel = new Stack<TreeNode>();  
          res.add(ls);
          ls = new ArrayList<>();             
         
    }
           
          return res;

    }
    