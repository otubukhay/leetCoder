 /*
 Let n be the length of the input string (the total number of symbols in it).
 Time complexity : O(1).
As there is a finite set of roman numerals, the maximum number possible number can be 3999, 
which in roman numerals is MMMCMXCIX. As such the time complexity is O(1).
 */
 public int romanToInt(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put( 'C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;        
        int prev = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            int val = map.get(s.charAt(i));
            if(val < prev)
            {
                sum = sum - val;    
            }
            else
            {
                sum = sum + val;     
            }
            
            prev = val;
        }
        
        return sum;
    }