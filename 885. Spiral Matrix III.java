public int[][] spiralMatrixIII(int R, int C, int r0, int c0) 
     {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
        List<int[]> res = new ArrayList<>();
        int steps = 0, curDirIndex = 0; // move <steps> steps in the <curDirIndex> direction
        res.add(new int[]{ r0, c0 });
       
        while(res.size() < R * C) 
        {
            if(curDirIndex % 2 == 0) 
            {
                steps++; // when move east or west, the length of path need plus 1 
            }
            
            for(int i = 0; i < steps; i++) 
            {
                r0 += directions[curDirIndex][0];
                c0 += directions[curDirIndex][1];
                if(r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
                { 
                    res.add(new int[]{ r0, c0 });
                }
            }
             
            curDirIndex = (curDirIndex + 1) % 4; // turn to next direction
        }
         
        return res.toArray(new int[R * C][2]);
    }