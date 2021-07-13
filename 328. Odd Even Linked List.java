public ListNode oddEvenList(ListNode head)
    {
        if(head == null || head.next == null)
            return head;        
              
        ListNode even = head.next, odd = head;
        ListNode evenCur = even, oddCur = odd;
      
        ListNode cur = head.next.next;
        boolean oddIndex = true;
        while(cur != null)
        {
            if(oddIndex)
            {
               oddCur.next = cur;
               oddCur = cur;
            }
            else
            {
                evenCur.next = cur;
                evenCur = cur;
            }
                
            cur = cur.next;    
            oddIndex = !oddIndex;            
        }
        
        oddCur.next = even;
        evenCur.next = null;       
        
        return odd; // or head
    }