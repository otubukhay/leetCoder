class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    Integer front = null;
    /** Initialize your data structure here. */
    public MyQueue() {
       
    }
    
     public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) 
        {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();    
    }

    // Get the front element.
    public int peek() {
          if (!s2.isEmpty()) 
          {
            return s2.peek();
          }
          
          return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }