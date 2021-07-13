    public String simplifyPath(String path) 
	{
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
       
        for (String dir : path.split("/")) 
        {
            if (dir.equals("..") && !stack.isEmpty())
			{ 
                stack.pop();
			}
            else if (!skip.contains(dir)) 
			{
                stack.push(dir);
			}
        }

        StringBuilder res = new StringBuilder("");
        for (String dir : stack) 
        {
            res.append("/").append(dir);
        }
        
        return res.length() == 0 ? "/" : res.toString();
      }