     /*
		  Let n be the length of the input array and LL be the number of non-zero elements.
		  Time complexity: O(n) for creating the Hash Map; O(L) for calculating the dot product.
		  Space complexity: O(L) for creating the Hash Map, as we only store elements that are non-zero. O(1) for calculating the dot product.
	 */
	  Map<Integer, Integer> indexMap = new HashMap<>();
      int n = 0;
      
      SparseVector(int[] nums) 
      {
            for (int i = 0; i < nums.length; i++)
            {
              if (nums[i] != 0)
              {
                indexMap.put(i, nums[i]);
              }
            }

            n = nums.length;
      }
  
      // Return the dotProduct of two sparse vectors
      public int dotProduct(SparseVector vec) 
      {
        if (indexMap.size() == 0 || vec.indexMap.size() == 0) 
            return 0;
          
        if (indexMap.size() > vec.indexMap.size())
          return vec.dotProduct(this);
        
        int productSum = 0;        
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) 
        {
          int index = entry.getKey();
          Integer vecValue = vec.indexMap.get(index);
          if (vecValue == null) 
              continue; 
          productSum += (entry.getValue() * vecValue);
        }
        return productSum;
      }
	  
***********************************************************************************************************************	  
	  
    List<int[]> pairs;

    SparseVector(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) 
		{
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                q++;
            }
            else {
                p++;
            }
        }
        return result;
    }
	