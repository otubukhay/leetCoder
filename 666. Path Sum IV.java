public int pathSumIV(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>(); // cnt of each node in the calculation
                                                    // equals the number of leafs in the substree
        for(int j = nums.length - 1; j >= 0; j--)
        {
            int i = nums[j];
            int level = i / 100; // level of current node
            int pos = (i - (i/100) * 100) / 10; // position of current node
            int p1 = 2 * pos - 1, p2 = p1 + 1; // position of left and right child
            int k = i / 10, k1 = (level+1) * 10 + p1, k2 = (level+1) * 10 + p2;
            if(!cnt.containsKey(k1) && !cnt.containsKey(k2)) 
            { // leaf
                cnt.put(k, 1);
            } 
            else 
            { // internal
                int left = cnt.getOrDefault(k1, 0);
                int right = cnt.getOrDefault(k2, 0);
                cnt.put(k, left + right);
            }
        }

        int result = 0;
        for(int i : nums) 
        {
            int key = i / 10, value = i % 10;
            result += cnt.get(key) * value;
        }
        return result;
    }