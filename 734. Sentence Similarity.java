  public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> similarPairs) 
    {
        if (words1.length != words2.length) 
            return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : similarPairs) 
        {
            map.putIfAbsent(p.get(0), new HashSet<>());
            map.putIfAbsent(p.get(1), new HashSet<>());
            map.get(p.get(0)).add(p.get(1));
            map.get(p.get(1)).add(p.get(0));
        }
        
        for (int i = 0; i < words1.length; i++) 
        {
            if (words1[i].equals(words2[i])) 
                continue;
            
            if (!map.containsKey(words1[i])) 
                return false;
            
            if (!map.get(words1[i]).contains(words2[i])) 
                return false;
        }
        
        return true;