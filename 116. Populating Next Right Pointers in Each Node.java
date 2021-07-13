public Node connect(Node root) 
    {
        if(root == null)
            return root;
        
        Node curLevel = root;        
        while(curLevel != null)
        {            
            Node cur =  curLevel;
            while(cur != null)
            {
                if(cur.left != null)
                    cur.left.next = cur.right;                
                
                if(cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                
                cur = cur.next;
            }
            
            curLevel =  curLevel.left;            
        }            
        
        return root;
    }