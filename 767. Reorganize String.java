 public String reorganizeString(String S) 
    {
        Map<Character, Integer> m = new HashMap();
        for(char c : S.toCharArray())
		{
			m.put(c,  m.getOrDefault(c, 0) + 1);
		}
        
        PriorityQueue<Character> p = new PriorityQueue<Character>((a, b) -> m.get(b) - m.get(a)); //Maximum 
        p.addAll(m.keySet());
        
        StringBuilder b = new StringBuilder();       
        while(p.size() > 1)
        {
            Character max = p.remove();
            Character secondMax = p.remove();
            
            b.append(max);
            b.append(secondMax);
            
            m.put(max, m.get(max) - 1);
            m.put(secondMax, m.get(secondMax) - 1);
            
            if(m.get(max) > 0)
                p.add(max);
            
            if(m.get(secondMax) > 0)
                p.add(secondMax);
        }
        
        if(!p.isEmpty())
        {
            char last = p.remove();
            if(m.get(last) > 1)
                return "";
            
            b.append(last);
        }
        
        return b.toString();
    }