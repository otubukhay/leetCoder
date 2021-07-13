    public void reorderList(ListNode head) 
    {
      if(head == null || head.next == null)
          return;
            
      ListNode prev = null, slow = head, fast = head, currentHead = head;
      while(fast != null && fast.next != null) 
      {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
      }
      
      prev.next = null;
      ListNode secondHalf = reverse(slow);
      merge(currentHead, secondHalf);
    }
    
    ListNode reverse(ListNode cur){
        if(cur == null)
            return cur;
        
        ListNode prev = null;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
	void merge(ListNode first, ListNode second) 
    {
      while(first != null)
      {
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        first.next = second;
        
        if(firstNext == null)
           break;
            
        second.next = firstNext;       
        first = firstNext;
        second = secondNext;
      }
    }
    