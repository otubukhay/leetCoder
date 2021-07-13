  public boolean carPooling(int[][] trips, int capacity) 
    {    
      int stops[] = new int[1001]; 
      for (int t[] : trips)
      {
          stops[t[1]] += t[0];
          stops[t[2]] -= t[0];
      }
        
      int load = 0;
      for (int i = 0; i < 1001; ++i) 
      {
          load += stops[i];
          if(load > capacity)
              return false;
      }
        
      return true;
    }
	
	**********************************************
	 public boolean carPooling(int[][] trips, int capacity) 
    {        
      Map<Integer, Integer> map = new TreeMap<>();
      for (int t[] : trips)
      {             
          map.put(t[1], map.getOrDefault(t[1], 0) + t[0]);
          map.put(t[2], map.getOrDefault(t[2], 0) - t[0]);       
      }
        
      int load = 0;
      for (int key : map.keySet()) 
      {
          load += map.get(key);
          if(load > capacity)
              return false;
      }
        
      return true;
    }