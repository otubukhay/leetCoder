 /*
	Given an array of positive integers arr (not necessarily distinct), return the lexicographically largest permutation that is smaller than arr, that can be made with exactly one swap
	(A swap exchanges the positions of two numbers arr[i] and arr[j]). If it cannot be done, then return the same array.

	Example 1:
	Input: arr = [3,2,1]
	Output: [3,1,2]
	Explanation: Swapping 2 and 1.
	 
 */
 
    public int[] prevPermOpt1(int[] arr)
    {
        if(arr.length <= 1)
            return arr;
        
        int i = arr.length - 2;
        while(i >= 0 && arr[i] <= arr[i + 1])
        {
            i--;    
        }
        
        if(i >= 0)
        {
            int index = i + 1;               
            for(int j = i + 1; j < arr.length; j++)
            {
				 //Get the higest possible number  that is less than arr[i];
                 if(arr[j] < arr[i] && arr[j] > arr[index])  
                 {
                     index = j;
                 }
            }
            
            swap(i, index, arr);
        }
        
        return arr;
    }
    
    void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }