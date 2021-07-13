 public Node connect(Node root)
    {
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);        
        while(!q.isEmpty())
        {   
            Node prev = null;
            int size =  q.size();
            for(int i = 1; i <= size; i++)
            {
                Node cur = q.poll();
                if(cur.left != null)
                {
                    q.add(cur.left);
                }
                
                if(cur.right != null)
                {
                    q.add(cur.right);
                }
                
                if(prev != null)
                {
                    prev.next = cur;    
                }
                
                prev = cur;
            }
           
        }            
        
        return root;
    }