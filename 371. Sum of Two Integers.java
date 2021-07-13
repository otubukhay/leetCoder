    public static int getSum(int a, int b) 
    {
        while (b != 0) 
		{
            int xOrResult = a ^ b;
            int andResult = (a & b) << 1;

            a = xOrResult;
            b = andResult;
        }

        return a;
    }
