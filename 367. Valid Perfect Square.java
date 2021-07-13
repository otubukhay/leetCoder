public boolean isPerfectSquare(int num) 
   {
        int left = 1, right = num;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;            
            int res = num / mid, remain = num % mid;
            if (res == mid && remain == 0) 
            {
                return true;
            }
            
            if(res > mid)// mid is small -> go right to increase mid
            { 
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }