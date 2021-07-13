 public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        
        while(cur != null)
        {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null)
        {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
            
    }
	
	*******************************************************************
	 public Node copyRandomList(Node head) {
        if(head == null)
            return head;
              
        Node cur = head;        
        while(cur != null)
        {           
           Node next = cur.next;          
           Node newN = new Node(cur.val);
           cur.next = newN;
           newN.next = next;            
           cur = next;        
        }
        
        Node ret = head.next;
        cur = head;
        while(cur != null && cur.next !=  null)
        {
           cur.next.random = cur.random  != null ? cur.random.next :  null;
           cur = cur.next.next;          
        }
        
        cur = head;
        while(cur != null && cur.next !=  null)
        {
           Node next = cur.next; 
           cur.next = cur.next.next;       
            
           cur = next;
        }
        
        return ret;
            
    }