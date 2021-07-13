 public String multiply(String num1, String num2) 
    {
        int m = num1.length();
        int n = num2.length();
        int[] prod = new int[m + n];
        
        for(int i = m - 1; i >= 0; i--)
        {            
            for(int j = n - 1 ; j >=0 ;j--)
            {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';                
                prod[i + j + 1] += a * b; // key
            }
        }
        
        int carry = 0;       
        for (int i = prod.length - 1; i >= 0; i--)
        {
            int sum =  carry + prod[i];
            prod[i] = sum % 10;
            carry = sum/10;
        }
        
        StringBuilder sb = new StringBuilder(); 
        for (int num : prod)
        {
            sb.append(num); 
        }
        
        while (sb.length() != 0 && sb.charAt(0) == '0') 
        {
            sb.deleteCharAt(0); 
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }