    public ListNode removeNthFromEnd(ListNode head, int n) 
    {        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        for(int i = 1; i <= n; i++)
        {
            fast = fast.next;              
        }               
       
        ListNode slow = dummy;
        while(fast != null && fast.next != null)
        {            
            fast = fast.next;
            slow = slow.next;
        }        
       
        slow.next = slow.next.next;        
        return dummy.next;
    }