 /*    
     Use HashMap to store a remainder and its associated index while doing the division so that whenever a same remainder comes up, we know there is a repeating            fractional part. Please comment if you see something wrong or can be improved. Cheers!    
    */
    public String fractionToDecimal(int numerator, int denominator) 
    {
        if (numerator == 0) 
        {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();        
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);        
        num %= den;
        if (num != 0) 
        {
            // fractional part
			res.append(".");
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			map.put(num, res.length());
			while (num != 0) 
			{
				num *= 10;
				res.append(num / den);
				num %= den;
				if (map.containsKey(num)) 
				{
					int index = map.get(num);
					res.insert(index, "(");
					res.append(")");
					num = 0;
				}
				else 
				{
					map.put(num, res.length());
				}
			}
        }
        
        
        return res.toString();
    }