/*
Let N be the number of input equations and M be the number of queries.

Time Complexity: O(M*N)
*/
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        Map<String, Map<String, Double>> map = buildMap(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) 
        {
            List<String> query = queries.get(i);
            result[i] = getExpressionValue(query.get(0), query.get(1), map, new HashSet<String>());            
        }
        
        return result;
    }
    
    Map<String, Map<String, Double>> buildMap(List<List<String>> equations, double[] values)
    {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for(int i = 0; i < equations.size(); i++) 
        {
            List<String> equation = equations.get(i);
            if(!map.containsKey(equation.get(0))) 
            {
                map.put(equation.get(0), new HashMap<String, Double>());                
            }
            
            if(!map.containsKey(equation.get(1))) 
            {
                map.put(equation.get(1), new HashMap<String,Double>());                
            }
           
            map.get(equation.get(0)).put(equation.get(1), values[i]);            
            map.get(equation.get(1)).put(equation.get(0), 1/values[i]);   
        }
        
        return map;
    }
    
    private double getExpressionValue(String start, String end, Map<String, Map<String, Double>> map, 
                       Set<String> visited)
    {       
        if(!map.containsKey(start)) 
            return -1.0;
        
        if(map.get(start).containsKey(end))
            return map.get(start).get(end);
        
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : map.get(start).entrySet()) 
        {
            String neighbourKey = neighbour.getKey(); 
            double neighbourValue = neighbour.getValue();
            if (!visited.contains(neighbourKey)) 
            {
                double calculatedVal = getExpressionValue(neighbourKey, end, map, visited);
                if (calculatedVal != -1.0)
                {
                    return neighbourValue * calculatedVal;
                }
            }
        }
        
        return -1.0;
    }