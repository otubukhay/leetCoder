public int[] plusOne(int[] digits) 
    {
        for (int index = digits.length - 1; index >= 0; index--) 
        {
            if (digits[index] == 9) 
            {
                digits[index] = 0;
            } 
            else 
            {
                digits[index]++;
                return digits;
            }
        }
        
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;    
    }