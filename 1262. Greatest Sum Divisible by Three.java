   /*
    Add all together, if sum%3==0, return sum.
    if sum % 3 == 1, remove the smallest number which has n % 3 == 1.
    if sum % 3 == 2, remove the smallest number which has n % 3 == 2.    
    one pass, and we need to keep the smallest two numbers that have n1%3==1 and n2%3==2.
	*/

	public int maxSumDivThree(int[] nums) 
	{
        int sum = 0, leftOne = 20000, leftTwo = 20000;
        for (int n : nums) 
        {
            sum += n;
            if (n % 3 == 1) 
            {
                leftTwo = Math.min(leftTwo, leftOne + n);
                leftOne = Math.min(leftOne, n);
            }

            if (n % 3 == 2) 
            {
                leftOne = Math.min(leftOne, leftTwo + n);
                leftTwo = Math.min(leftTwo, n);
            }
        }

        if (sum % 3 == 0) 
		{
            return sum;
        }
		
        return (sum % 3 == 1) ? sum - leftOne : sum - leftTwo;

    }