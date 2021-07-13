  public void merge(int[] nums1, int m, int[] nums2, int n) 
  {
        int i = m - 1;
        int j = n - 1;
        
        int k = m + n - 1;
        while(i >= 0 || j >= 0)
        {
            int one = (i >= 0) ? nums1[i] : Integer.MIN_VALUE;
            int two = (j >= 0) ? nums2[j] : Integer.MIN_VALUE;
            
            if(one >= two)
            {
                nums1[k--] = one;                
                i--;
            }
            else
            {
                nums1[k--]= two;
                j--;
            }           
            
        }
    }   
    