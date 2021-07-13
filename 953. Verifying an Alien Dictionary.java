 public boolean isAlienSorted(String[] words, String order) 
    {        
        int[] orderArray = new int[26];
        for(int i = 0; i < order.length(); i++)
        {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < words.length - 1; i++)
        {
            if(!words[i].equals(words[i + 1]) && !valid(words[i], words[i + 1], orderArray))
            {
               return false;
            }
        }
        
        return true;
    }
    
    boolean valid(String one, String two, int[] order)
    {
        for(int i = 0; i < Math.min(one.length(), two.length()); i++)    
        {
            if (one.charAt(i) != two.charAt(i))
            {
                return order[one.charAt(i) - 'a'] < order[two.charAt(i) - 'a'];
            }
        }
        
        return one.length() <= two.length();
    }