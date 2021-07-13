    public String minRemoveToMakeValid(String s) 
    {      
      Stack<Integer> st = new Stack<>();      
      char[] temp = s.toCharArray();
      for (int i = 0; i < temp.length; ++i) 
      {
        if (temp[i] == '(') 
        {
            st.push(i);
        }          
        else if (temp[i] == ')') 
        {
          if (!st.empty()) 
          {
              st.pop();
          }
          else 
          {             
             temp[i] = ' ';
          }
        }
      }
        
      while (!st.empty())
           temp[st.pop()] = ' ';        
        
      StringBuilder bu = new StringBuilder();
      for(char ch : temp)
          if(ch != ' ')
              bu.append(ch);
      
      return bu.toString();     
    }