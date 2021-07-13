 public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode after = head.next;        
        ListNode temp = swapPairs(after.next);
        head.next = temp;
        after.next = head;
        
        return after;
    }