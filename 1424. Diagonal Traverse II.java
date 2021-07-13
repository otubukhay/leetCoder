 public int[] findDiagonalOrder(List<List<Integer>> nums) 
    {     
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;
        
        int length = 0;
        for(int i = 0; i < nums.size(); i++) 
        {
            for (int j = 0; j < nums.get(i).size(); j++) 
            {
                length++;
                if(!map.containsKey(i + j))
                {
                    map.put(i + j, new ArrayList<>());
                }
                
                map.get(i + j).add(nums.get(i).get(j));
                maxKey = Math.max(maxKey, i + j);
            }
        }
    
        int[] result = new int[length];
        int index = 0;
        for(int key = 0; key <= maxKey; key++)
        {
            for(int i = map.get(key).size() - 1; i >= 0; i--)
            {
                result[index++] = map.get(key).get(i);
            }
        }
        
        return result;
    }