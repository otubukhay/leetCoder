     public String removeDuplicates(String s, int k)
     {       
        Stack<Adjacent> st = new Stack<>();
        for (char c : s.toCharArray())
        {
            if(st.isEmpty() || st.peek().ch != c) 
            {
                st.push(new Adjacent(c, 1));
            }
            else 
            {
                st.peek().freq++;
            }
            
            if(st.peek().freq == k)
            {
                st.pop();
            }
        }
         
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) 
        {
            Adjacent peek = st.pop();
            sb.append(String.valueOf(peek.ch).repeat(peek.freq));
        }
         
        return sb.reverse().toString();
    }

    class Adjacent 
    {
        char ch;
        int freq;

        public Adjacent(char ch, int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }
    }