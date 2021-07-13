public int[] intersection(int[] nums1, int[] nums2) {        
        
        Set<Integer> s = new HashSet<>();
        for(int i : nums2)           
            s.add(i);
        
        Set<Integer> res = new HashSet<>();
        for(int i : nums1)
            if(s.contains(i))
                res.add(i);
        
        int[] array = new int[res.size()];
        
        int i = 0;
        for(int j :  res)
            array[i++] = j;
        
        return array;         
    }