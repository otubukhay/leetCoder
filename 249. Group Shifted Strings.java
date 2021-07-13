    //249. Group Shifted Strings
    public List<List<String>> groupStrings(String[] strings)
    {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings)            
        {
            String key = getKey(s);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
	
    private String getKey(String s) 
	{
        char[] chars = s.toCharArray();
        StringBuilder key = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            int diff = (chars[i] - '0') - (chars[i - 1] - '0');
			if (diff < 0)
				diff += 26;
            key.append(diff + 'a'); // String.valueOf(diff);
        }
        return key.toString();
    }