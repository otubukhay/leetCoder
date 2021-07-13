 public List<Integer> addToArrayForm(int[] A, int K) 
    {
        
        int carry = K;
        int index = A.length - 1;       
       
        List<Integer> result = new ArrayList();       
        while(index >= 0 || carry > 0)
        {
            int sum = carry + (index >= 0 ? A[index] : 0);
            carry  = sum/10;
            result.add(0, sum % 10);      
            index--;
        }        
        
        return result; 
    }