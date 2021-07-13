--------------------------------------------------------------------------
Find the maximum number in the list
---------------------------------------------------------------------------
  public Node insert(Node head, int insertVal)
 {
        if (head == null) 
		{
            Node node = new Node(insertVal);            
            node.next = node;
            return node;
        }
        
        Node max = head;
        while (max.next != head && max.val <= max.next.val) 
		{
            max = max.next;
        }
        
        Node min = max.next, cur = min;
        if (insertVal >= max.val || insertVal <= min.val) 
		{
            Node node = new Node(insertVal, min);
            max.next = node;
        } 
		else 
		{
            while(cur.next.val < insertVal) 
			{
                cur = cur.next;
            }
            
            Node node = new Node(insertVal, cur.next);
            cur.next = node;
        }
        
        return head;
    }