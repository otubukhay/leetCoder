 public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
       
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null)
		{            
            if(head.val != val)
			{
                cur.next = head;
                cur = head;
            }
            
            head = head.next;
        }        
        
        cur.next = null;
        return dummy.next;    
    }