    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for(ListNode l : lists)
        {
            if(l != null)
            {
                p.add(l);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!p.isEmpty())
        {
            ListNode h = p.remove();
            cur.next = h;
            cur = h;
            
            if(h.next != null)
                p.add(h.next);
        }
               
        return dummy.next;
        //return mergeAll(lists, 0 , lists.length - 1);
    }
    
    ListNode mergeAll(ListNode[] lists, int low, int high)
    {
         if(low > high)
             return null;
        
         if(high == low)
             return lists[low];
        
        int mid = low + (high - low) / 2;
        ListNode left =  mergeAll(lists, low, mid);
        ListNode right =  mergeAll(lists, mid + 1, high);
        
        return merge(left, right);      
          
    }
    
    ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null || l2 == null)
            return l2 == null ? l1 : l2;       
        
        if(l1.val <= l2.val)
        {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = merge(l1, l2.next);
            return l2;
        }        
    }