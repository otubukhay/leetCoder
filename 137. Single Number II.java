    public int singleNumber(int[] nums) 
    {
        int res = 0;
        int countWithCurrentBitSet = 0;
        int mask = 0;

        for (int i = 0; i < 32; i++) 
        {
            mask = 1 << i;
            countWithCurrentBitSet = 0;
            for (int num : nums) 
            {
                if((num & mask) != 0) 
                {
                    countWithCurrentBitSet++;
                }
            }

            if ((countWithCurrentBitSet % 3) == 1) 
            {               
                res = res + (1 << i);
            }
        }

        return res;
    }
    