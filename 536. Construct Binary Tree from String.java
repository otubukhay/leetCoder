    public TreeNode str2tree(String s) 
    {
        if (s == null || s.length() == 0) 
            return null;
			
	        Stack<TreeNode> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) 
			{
				if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') 
				{
					int j = i;
					while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
					{
						i++;
					}

					TreeNode curt = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
					if (stack.isEmpty())
					{
						stack.push(curt);
					}
					else
					{
						TreeNode parent = stack.peek();
						if (parent.left == null) 
						{
							parent.left = curt;
						}
						else 
						{
						   parent.right = curt;
						}

						stack.push(curt);
					}
				}

				if (s.charAt(i) == ')') 
				{
					stack.pop();
				}
			}

			return stack.pop();
	}
	-----------------------------------------------------------------------------------	
    public TreeNode toTree(String str, int start, int end, Map<Integer, Integer> map) 
	{
        if(start > end) 
		{
            return null;
        }

        int sign = 1;        
        if ('-' == str.charAt(i)) {
            sign = -sign;
            i++;
        }

        int num = 0;
        TreeNode root = null;
        while (i <= end && Character.isDigit(str.charAt(i))) 
		{
            num = 10 * num + (str.charAt(i) - '0');
            i++;
        }

        root = new TreeNode(num * sign);
        if (i <= end) {
            int j = map.get(i);
            root.left = toTree(str, i + 1, j - 1, map);
            root.right = toTree(str, j + 2, end - 1, map);
        }

        return root;

    }

    Map<Integer, Integer> buildMap(String s) 
	{
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) 
		{
            if (s.charAt(i) == '(') 
			{
                st.push(i);
            } 
			else if (s.charAt(i) == ')') 
			{
                m.put(st.pop(), i);
            }

        }

        return m;
    }

    /**
     * @param s: a string
     * @return: a root of this tree
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Map<Integer, Integer> map = buildMap(s);
        return toTree(s, 0, s.length() - 1, map);
    }
