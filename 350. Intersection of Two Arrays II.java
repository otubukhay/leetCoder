 public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for(int cur : nums1)
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        
        List<Integer> result = new ArrayList();
        for(int cur : nums2)
        {
            if(map.containsKey(cur) && map.get(cur) > 0)
            {
                result.add(cur);
                map.put(cur, map.getOrDefault(cur, 0) - 1);                   
            }
        }
             
        int[] array = new int[result.size()];
        int index = 0;
        for(int cur : result)
            array[index++] =cur;
        
        return array;
    }