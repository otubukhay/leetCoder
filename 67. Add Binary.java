 public String addBinary(String a, String b) 
 {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuffer builder = new StringBuffer();
        while(i >=0 || j >= 0 || carry > 0)
        {
            int aVal = (i >= 0 && a.charAt(i) == '1') ? 1 : 0;
            int bVal = (j >= 0 && b.charAt(j) == '1') ? 1 : 0;
            
            int sum = aVal + bVal + carry;
            builder.append(String.valueOf(sum % 2));
            carry = sum/2;
            
            i--;
            j--;
        }
        
        
        return builder.reverse().toString(); 
    }