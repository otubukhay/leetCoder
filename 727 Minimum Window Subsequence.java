    public String minWindow(String S, String T) 
    {
        if (S.length() == 0 || T.length() == 0) 
        {
            return "";
        }

        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        while (right < S.length()) 
        {
            int tIndex = 0;           
            while (right < S.length()) 
            {
                if (S.charAt(right) == T.charAt(tIndex)) 
				{
                    tIndex++;
                }
				
                if (tIndex == T.length()) 
				{
                    break;
                }
                right++;
            }

            // if right pointer is over than boundary
            if (right == S.length()) 
            {
                break;
            }

            // use another slow pointer to traverse from right to left until find first character of T in S
            int left = right;
            tIndex = T.length() - 1;
            while (left >= 0) 
            {
                if (S.charAt(left) == T.charAt(tIndex)) 
                {
                    tIndex--;
                }

                if (tIndex < 0) 
                {
                    break;
                }

                left--;
            }

            // if we found another subsequence with smaller length, update result
            if (right - left + 1 < minLen) 
            {
                minLen = right - left + 1;
                result = S.substring(left, right + 1);
            }

            right = left + 1; //try find another window after the first char in the current window
        }
        return result;
	}