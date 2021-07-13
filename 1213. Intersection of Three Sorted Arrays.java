 /*Complexity Analysis
  Time Complexity: O(n), where nn is the total length of all of the input arrays.
  Space Complexity: O(1), as we only initiate three integer variables using constant space.
 */
 
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3)
    {
        List<Integer> arr = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0)
        {
            return arr;
        }

        int i = 0, j = 0, k = 0;
        int m = arr1.length, n = arr2.length, p = arr3.length;
        while (i < m && j < n && k < p) 
		{
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k])
			{
                arr.add(arr2[j]);
                i++;
                j++;
                k++;
            } 
			else 
			{
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (arr1[i] == min) 
				{
                    i++;
                }
                
                if (arr2[j] == min) 
				{
                    j++;
                }
                
                if (arr3[k] == min) 
				{
                    k++;
                }
            }
        }

        arr;
    }