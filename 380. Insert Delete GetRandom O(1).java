class RandomizedSet {

    List<Integer> list = null;
    Map<Integer, Integer> map = null;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        if(!map.containsKey(val))
        {
          map.put(val, list.size());   
          list.add(val);
            
          return true;
        }   
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
      if(!map.containsKey(val))
         return false;
        
      int index = map.get(val);
      if(index < list.size() - 1)
      {
         int lastVal = list.get(list.size() - 1);
         list.set(index, lastVal);
         map.put(lastVal, index);
      }
      
      map.remove(val);
      list.remove(list.size() - 1);
      return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom()
    {
         return list.get(rand.nextInt(list.size()));
    }
}
