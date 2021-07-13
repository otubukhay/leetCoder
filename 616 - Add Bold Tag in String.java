    public String addBoldTag(String s, String[] dict)
    {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) 
		{           
            for(String word : dict) 
			{
                if(s.startsWith(word, i)) 
                {
                    end = Math.max(end, i + word.length());
                }
            }
			
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) 
        {
            if (!bold[i]) 
            {
                result.append(s.charAt(i++));                
            } 
            else 
            {               
                result.append("<b>");
                while (i < s.length() && bold[i]) 
				{
                   result.append(s.charAt(i++)); 
                }
                result.append("</b>");
            }
        }

        return result.toString();
    }
	
	---------------------
	
