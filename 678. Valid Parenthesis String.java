 boolean checkValidString2(String s)
      {
            Stack<Integer> open = new Stack<>();
            Stack<Integer> star = new Stack<>();
            int len = s.length();

            for(int i = 0; i < s.length(); i++)
            {
                char cur = s.charAt(i);
                if(cur == '(') 
                {
                    open.push(i);
                } 
                else if (cur == '*') 
                {
                    star.push(i);
                } 
                else 
                {
                    if(open.empty()) 
                    {
                        if(star.empty())
                        {
                           return false;
                        }

                        star.pop();
                    }                 
                    else
                    {
                        open.pop();
                    }
                }
            }

            //Now process leftover opening brackets
            while (!open.empty())
            {
                if(star.empty() || open.pop() > star.pop()) 
                {
                    return false;
                } 
            }

            return true;
        }
	