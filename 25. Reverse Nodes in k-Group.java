 public ListNode reverseKGroup(ListNode head, int k) 
   {
        if(head  == null) 
            return null;
        
        ListNode cur = head;
        int count = 0;
        
        while(count < k && cur != null)
        {
            count++;
            cur = cur.next;
        }
        
        if(count == k)
        {
            cur = reverseKGroup(cur, k);
            while(count > 0)
            {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;      
                count--;
            }
            
            head = cur;
        }        
         
         return head;
    }    