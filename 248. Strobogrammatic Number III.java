 public static List<String> findStrobogrammatic(int n) 
 {
        List<String> result = new ArrayList<>(Arrays.asList(""));
        if (n % 2 == 1) 
		{
            result = new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
		
        while (n > 1) 
		{
            List<String> cur = result;
            result = new ArrayList();
            for (String i : cur) 
			{
                if (n > 3) 
				{
                    result.add('0' + i + '0');
                }
                result.add('1' + i + '1');
                result.add('8' + i + '8');
                result.add('6' + i + '9');
                result.add('9' + i + '6');
            }
            n -= 2;
        }
        return result;
    }

    public static int strobogrammaticInRange(String low, String high) 
    {
        int count = 0;
        List<String> rst = new ArrayList<>();
        for (int n = low.length(); n <= high.length(); n++) 
        {
            rst.addAll(findStrobogrammatic(n));
        }
        
        for (String num : rst)
        {
            if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0))
            {
                continue;
            }
            count++;
        }
        return count;
    }
