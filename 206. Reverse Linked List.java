 public ListNode reverseList(ListNode head) 
 {
        if(head == null || head.next == null)
            return head;
        
        ListNode reverse = reverseList(head.next);
        head.next.next= head;
        head.next = null;
        
        return reverse;
    }
	
	
**********************************************************
 public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
		while(head != null)
		{
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			
			head = next;
		}
        
        return reverse;
 }