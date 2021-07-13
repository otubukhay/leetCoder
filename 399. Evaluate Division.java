public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        HashMap<String, HashMap<String, Double>> map = buildMap(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) 
        {
            List<String> query = queries.get(i);
            result[i] = dfs(query.get(0), query.get(1), map, new HashSet<String>(), 1.0);
            if (result[i] == 0.0)
                result[i] = -1.0;
        }
        
        return result;
    }
    
    HashMap<String, HashMap<String, Double>> buildMap(List<List<String>> equations, double[] values)
    {
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String,Double>>();
        for (int i = 0; i < equations.size(); i++) 
        {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), new HashMap<String,Double>());                
            }
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new HashMap<String,Double>());                
            }
           
            map.get(equation.get(0)).put(equation.get(1), values[i]);            
            map.get(equation.get(1)).put(equation.get(0), 1/values[i]);   
        }
        
        return map;
    }
    
    private double dfs(String start, String end,  HashMap<String, HashMap<String, Double>> map, 
                       HashSet<String> set, double value) {
        if (set.contains(start)) 
            return 0.0;
        if (!map.containsKey(start) || !map.containsKey(end)) 
             return 0.0;
        if (start.equals(end)) 
            return value;
        
        set.add(start);        
     
        double tmp = 0.0;
        HashMap<String, Double> children = map.get(start);
        for(Map.Entry<String, Double> child : children.entrySet()){       
            tmp = dfs(child.getKey(), end, map, set, value * child.getValue());
            if (tmp != 0.0) {
                break;
            }
        }
        
        set.remove(start);
        return tmp;
    }