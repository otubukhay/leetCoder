 public int findPeakElement(int[] num) 
    {        
        int lo = 0, hi = num.length - 1;
        while(lo < hi)
        {  
            if(lo + 1 == hi)
            {
                return num[lo] > num[hi] ? lo : hi;
            }
            
            int mid = lo + (hi - lo)/2;
            if(num[mid] > num[mid - 1] && num[mid] > num[mid + 1])
            {
                return mid;
            }
            else if(num[mid - 1] > num[mid + 1])
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
            
        }
        
        return lo;    
    }  
	
**************************************************************************************************
**************************************************************************************************
public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi)
        {
           int mid = lo + (hi - lo)/2;          
           if(nums[mid] <= nums[mid + 1])
           {
              lo = mid + 1;    
           }
           else
           {
               hi = mid;
           }           
        }
        
        return lo;    
    }