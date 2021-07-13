    static int findKthSmallest(int[] arr, int k){
        return findKthSmallestOrLargest(arr, k - 1);
    }
    
    static int findKthLargest(int[] arr, int k){
        return findKthSmallestOrLargest(arr, arr.length - k);
    }
    
    static int findKthSmallestOrLargest(int[] arr, int k)
    {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) 
        {
            int index = findIndex(arr, lo, hi);
            if (index == k) 
            {
                return arr[index];
            }

            if (index > k) 
            {
                hi = index - 1;
            } 
            else 
            {
                lo = index + 1;
            }
        }

        return -1;
    }

    private static int findIndex(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int left = lo;

        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                swapping(arr, i, left);
                left++;
            }
        }

        swapping(arr, left, hi);
        return left;
    }

    private static void swapping(int[] arr, int i, int left) 
	{
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
    }
