public boolean isStrobogrammatic(String num) {
        // write your code here
        Map<Character, Character> map = new HashMap<>();
        map.put('6' ,'9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');

        int lo = 0; int hi = num.length() - 1;
        while(lo <= hi)
        {
            char f = num.charAt(lo);
            char b = num.charAt(hi);
            
            if(!map.containsKey(f) || !map.containsKey(b) || map.get(f) != b)
            {
                return false;               
            }           

            lo++;
            hi--;
        }
        
        return true;    
    }