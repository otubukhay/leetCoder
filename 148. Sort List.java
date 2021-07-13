 public ListNode sortList(ListNode head) 
    {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode one, ListNode two)
    {
        if(one == null || two == null)
            return two == null ? one : two;
       
        if(one.val <= two.val)
        {
            one.next = merge(one.next, two);
            return one;
        }
        else
        {
            two.next = merge(one, two.next);
            return two; 
        }               
    }

    ListNode getMid(ListNode head) 
    {
        ListNode midPrev = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) 
        {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(midPrev != null)
            midPrev.next = null;
        
        return slow;      
    }