public int findInMountainArray(int target, MountainArray mountainArr)
    {
        int n = mountainArr.length() - 1;
        int pivot = findPivot(mountainArr);
        
        if (mountainArr.get(pivot) == target) 
        {
            return pivot;
        }

        int index = binarySearch(0, pivot - 1, mountainArr, target, true);
        if (index > -1) 
        {
            return index;
        }        
        return binarySearch(pivot + 1, n, mountainArr, target, false);
    }
   

    int findPivot(MountainArray mountainArr)
    {
        int lo = 0;
        int hi = mountainArr.length() - 1;

        while (lo < hi) 
        {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) 
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
    
     int binarySearch(int lo, int hi, MountainArray mountainArr,
                             int target, boolean asc)
     {
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) == target) 
            {
                return mid;
            }

            if (asc) 
            {
                if (mountainArr.get(mid) < target) 
                {
                    lo = mid + 1;
                } 
                else 
                {
                    hi = mid - 1;
                }
            } 
            else 
            {
                if (mountainArr.get(mid) < target) 
                {
                    hi = mid - 1;
                } 
                else 
                {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }