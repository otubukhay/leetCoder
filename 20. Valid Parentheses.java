    public boolean isValid(String s) {       
        
        return isValid(s.toCharArray());                
    }   

    public boolean isValid(char[] str)
    {
        if(str == null || str.length == 0)
            return true;

        Map<Character, Character> map = buildMap();
        Stack<Character> stack = new Stack();
        for(Character cur : str)
        {
            if(!map.containsKey(cur))
            {
                stack.push(cur);
            }
            else
            {
               if(stack.isEmpty() || stack.pop() != map.get(cur))
                    return false;
            }
        }	
            
        return stack.isEmpty();
    }

    private Map<Character,Character> buildMap()
    {
       Map<Character, Character> map = new HashMap();
       map.put(']','[');
       map.put('}','{');
       map.put(')','(');        
       return map;
    }    