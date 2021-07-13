public ListNode partition(ListNode head, int x) 
    {
        if(head == null)
            return null;
        
        ListNode lower = new ListNode(-1);
        ListNode higher = new ListNode(-1);
        
        ListNode prevLower = lower;
        ListNode prevHigher = higher;        
        
        ListNode cur = head;
        while(cur != null)
        {
            if(cur.val < x)
            {                
                prevLower.next = cur;                
                prevLower = cur;
            }
            else
            {
                prevHigher.next = cur;                
                prevHigher = cur;   
            }
            
            cur = cur.next;            
        }
        
        prevLower.next = higher.next;  // key
        prevHigher.next = null; // key
        return lower.next;
    }