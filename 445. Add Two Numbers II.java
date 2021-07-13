   public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        
        Stack<Integer> stOne = getStack(l1);
        Stack<Integer> stTwo = getStack(l2);        
        
        ListNode cur = null;        
        int carry = 0;
        while(!stOne.isEmpty() || !stTwo.isEmpty() || carry > 0)
        {
            int valOne = !stOne.isEmpty() ? stOne.pop() : 0;
            int valTwo = !stTwo.isEmpty() ? stTwo.pop() : 0;
   
            ListNode newNode = new ListNode((valOne + valTwo + carry)%10);
            newNode.next = cur;
            carry = (valOne + valTwo + carry)/10;            
            cur = newNode;
        }
        
        return cur;
    }
    
   
    Stack<Integer> getStack(ListNode l1)
    {
        Stack<Integer> stack = new Stack();
        while(l1 != null)
        {
            stack.push(l1.val);
            l1 = l1.next;
        }  
        
        return stack;