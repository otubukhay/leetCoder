   public ListNode reverseBetween(ListNode head, int m, int n) 
    {   
        if(head == null) 
            return head;        
        
        ListNode dummy = new ListNode(0);       
        
        ListNode prev = dummy;
        ListNode cur = head;
        for(int i = 1; i <= m - 1; i++)
        {
            prev.next = cur;
            prev = cur;
            cur = cur.next;   
        }
        
        prev.next = reverseN(cur,  n - m + 1);
        return dummy.next;
    }    
        
    ListNode reverseN(ListNode head, int n) 
    {
        if(head == null || n == 0)
            return head;        
       
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
       
        while(cur != null &&  n > 0)
        { 
            next = cur.next;
            cur.next = prev;
            prev = cur;            
            cur = next;  
            n--;
        }
        
       head.next = next;       
       return prev;        
    }    