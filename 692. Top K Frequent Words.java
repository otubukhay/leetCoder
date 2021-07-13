public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for(String item : words)
        {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        PriorityQueue<String> q = new PriorityQueue<String>(
            (a, b) ->  map.get(a).equals(map.get(b)) ? 
                b.compareTo(a) : map.get(a) - map.get(b));   
        
       
        for(String num : map.keySet())
        {
            q.add(num);
            if(q.size() > k){
                q.remove();
            }
        }
        
        List<String> ls = new ArrayList();
        while(!q.isEmpty()){
           ls.add(q.remove());
        }
        
        Collections.reverse(ls);
        return ls;     
    }    