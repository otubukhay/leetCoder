 public int firstBadVersion(int n) {
        
        int lo = 1;
        int hi = n;
        
        int index = -1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                index = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return index;
    }
    