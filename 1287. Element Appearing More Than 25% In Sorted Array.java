 public int findSpecialInteger(int[] arr) 
    {
        int n = arr.length;
        if(n == 1)
        {
            return arr[0];
        }
        
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4], arr[n/2], arr[(3 * n)/4]));
        for (int element : list) 
        {
            int firstPos = findPositions(arr, element, true);
            int lastPos = findPositions(arr, element, false);
            if(lastPos - firstPos + 1 > n/4) 
            {
                return element;
            }
        }
        
        return -1;
    }
    
    int findPositions(int[] arr, int target, boolean first)
    {
       int lo = 0;
       int hi = arr.length - 1;
        
       int pos = -1;
       while(lo <= hi)
       {
          int mid = lo + (hi - lo)/2;
          if(arr[mid] == target)
          {
              pos = mid;
              if(first)
              {
                 hi = mid - 1;    
              }
              else
              {
                 lo = mid + 1;    
              }
          }
          else if(arr[mid] < target)
          {
               lo = mid + 1;    
          }
          else
          {
               hi = mid - 1;    
          }                     
       }
        
       return pos;
    }
   