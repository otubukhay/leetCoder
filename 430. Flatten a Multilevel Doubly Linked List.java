public ListNode flatten(ListNode head) {
        if (head == null) {
            return head;
        }
		
        ListNode p = head;
        while (p != null)
		{
            /* CASE 1: if no child, proceed */
            if (p.child == null)
			{
                p = p.next;
            }
			else
			{
                /* CASE 2: got child, find the tail of the child and link it to p.next */
                ListNode temp = p.child;
                while (temp.next != null) 
				{
                    temp = temp.next;
                }

                temp.next = p.next;
                if (p.next != null)
				{
                    p.next.prev = temp;
                }

                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
        }
        return head;
    }