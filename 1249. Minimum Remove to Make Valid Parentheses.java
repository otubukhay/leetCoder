    public String minRemoveToMakeValid(String s) 
    {      
      Stack<Integer> st = new Stack<>();     //Only has index of opening braces 
      char[] temp = s.toCharArray();
      for (int i = 0; i < temp.length; ++i) 
      {
        if (temp[i] == '(') 
        {
            st.push(i);
        }          
        else if (temp[i] == ')') 
        {
          if (!st.empty())  //since we only keep opening braces index in stack, if not empty means there's matching opening brace for this closing
          {
              st.pop();
          }
          else 
          {             
             temp[i] = ' ';      //if empty, no opening brace to match
          }
        }
      }
        
      while (!st.empty())     //when we have tooo many opening braces, mark their indices as empty
           temp[st.pop()] = ' ';        
        
      StringBuilder bu = new StringBuilder();
      for(char ch : temp)
          if(ch != ' ')
              bu.append(ch);
      
      return bu.toString();     
    }


//Solution 2

 public String minRemoveToMakeValid(String s) 
    { 
      //scan forards, remove invalid closing
      //scan backwards, remove invalid opening
      // reverse result    
      int opens = 0;      
      StringBuilder bu = new StringBuilder();
      for (char c :  s.toCharArray()) 
      {
        if (c == '(') 
        {
           opens++;
        }          
        else if (c == ')') 
        {
          if (opens == 0) 
          {
              continue;
          }         
          opens--;
        }

        bu.append(c);
      }
      
      StringBuilder result = new StringBuilder();
      for(int i = bu.length() - 1; i >= 0; i--){
            if(bu.charAt(i) == '(' && opens-- > 0)
               continue;
            result.append(bu.charAt(i));
      }
      
      return result.reverse().toString();     
    }
