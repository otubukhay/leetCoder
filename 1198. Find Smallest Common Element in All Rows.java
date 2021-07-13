O(MN)
O(MN)
class Solution
 {
    public int smallestCommonElement(int[][] mat) 
	{
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) 
		{
            for (int j = 0; j < n; j++) 
			{
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) 
		{
            if (map.get(key) == m) 
			{
                min = Math.min(min, key);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

********************************************************************************
O(MNlogN)
O(1)
********************************************************************************
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i : mat[0]) 
		{
            boolean found = true;
            for (int j = 0; j < m; j++) 
			{
                if (!helper(mat[j], i)) 
				{
                    found = false;
                    break;
                }
            }
			
            if (found) 
			{
                return i;
            }
        }
        return -1;
    }

    private boolean helper(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) 
		{
            int mid = left + (right - left) / 2;
            if (row[mid] > target) 
			{
                right = mid - 1;
            } 
			else if (row[mid] < target)
			{
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}