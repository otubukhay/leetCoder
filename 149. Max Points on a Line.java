public int maxPoints(int[][] points) {
        if (points == null) 
        {
            return 0;
        }
           
        if (points.length <= 2)
        {
            return points.length;
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for (int i = 0; i < points.length; i++) 
        {
            map.clear(); // Key clear map
            int same = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) 
            {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];

                if (diffX == 0 && diffY == 0) 
                {
                    same++;                    
                }
                else
                {
                    int gcd = generateGCD(diffX, diffY);
                    if (gcd != 0)  // Key
                    {
                        diffX /= gcd;
                        diffY /= gcd;
                    }

                    if (map.containsKey(diffX))
                    {
                        if (map.get(diffX).containsKey(diffY)) 
                        {
                            map.get(diffX).put(diffY, map.get(diffX).get(diffY) + 1);
                        } 
                        else
                        {
                            map.get(diffX).put(diffY, 1);
                        }
                    } 
                    else 
                    {
                        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                        m.put(diffY, 1);
                        map.put(diffX, m);
                    }

                    max = Math.max(max, map.get(diffX).get(diffY));    // Key max we have after including this point
                }
               
            }

            result = Math.max(result, max + same + 1); // key =  max points +  those with same value, + the point (i) itself
        }

        return result;

    }

    private int generateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return generateGCD(b, a % b);   // Key mod not divide
        }
    }
