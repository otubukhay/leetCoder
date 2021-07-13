  
    public List<Integer> pancakeSort(int[] A) 
    {        
        List<Integer> result = new ArrayList();       
        Map<Integer, Integer> map = new HashMap();
        for(int index = 0; index < A.length; index++)
        {
           map.put(A[index], index);          
        }
        
        int maxNumber = A.length;
        for(int index = 0; index < A.length; index++)
        {
           int maxIndex = map.get(maxNumber);
           result.add(maxIndex + 1);
           flip(0, maxIndex, A, map);
           
           result.add(A.length - index);
           flip(0, A.length - index - 1, A , map);
           
           maxNumber--;
        }
        
        return result;
    }
    
    void flip(int start, int end, int[]A, Map<Integer, Integer> map)
    {        
         while(start < end)
         {             
            map.put(A[start], end);
            map.put(A[end], start);
            
            int temp =  A[start];
            A[start] = A[end];
            A[end] = temp;
             
            start++;
            end--;        
         }      
    }