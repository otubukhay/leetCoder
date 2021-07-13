public List<Integer> findAnagrams(String s, String p) 
    {
         List<Integer> list = new ArrayList<>();
         if (s == null || s.length() == 0 || p == null || p.length() == 0) 
            return list;
          
          int[] pCount = new int[26];
          for(char c : p.toCharArray())
          {
              pCount[c - 'a']++;    
          }    
          
          int[] sCount = new int[26];     
          int start = 0;
          for(int i = 0; i < s.length(); i++)
          {
              char c = s.charAt(i);
              sCount[c - 'a']++;  

              if(i - start + 1 >= p.length())
              {                 
                  if(Arrays.equals(sCount, pCount))
                  {
                     list.add(start);
                  }

                  sCount[s.charAt(start) - 'a']--;
                  start++;              
              }
          }      

          return list;