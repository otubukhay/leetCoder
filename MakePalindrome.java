tacocat -> true
tacocats -> true (we can make it palindrome by removing at most N char)
  tacocat, acocoa


tacocatss, n = 2 = > true

O(n)  where n is the length of the string

trivail = null ""
1. a
2. ab
3. aa
4. aba
5. xyz

n = 2
  visistedSET ();


[tacocats, acocatss ] n  = 1
[tacocat, acocats , acocats, acocatss] =  n = 0                                                                                       n > 0
  
  str -> l (l  is size of the string)
  
  
  
  

public boolean makeItPali(String str, int n){
 
    if(str == null || str.length() == 0)
       return true;
  
    
    Queue<String> qu = new LinkedList<>();
    qu.add(str);
    Set<String> set = new HashSet();
    set.add(str);
  
    while(!qu.isEmpty())
    {    
        int size = qu.size();
        for(int i = 1; i <= size; i++)
        {

          String current = qu.remove();

          int lo = 0;
          int hi = current.length() - 1;

          if(checkPali(current, lo,  hi));
            return true;

          if(n > 0)
          {

            while(lo < hi)        
            { 
              if(current.charAt(lo) != current.charAt(hi))
              {
                 String withoutHi = current.substring(lo, hi - lo);  // tacocats  (0, 2) (0, 6) lo = 0, hi = 7
                 if(!set.contains(withoutHi))
                 {
                   qu.add(withoutHi);
                   set.add(withoutHi);
                 }

                 String withoutLo =  current.substring(lo + 1, hi + 1);  // tacocats 
                 if(!set.contains(withoutLo))
                 {
                    qu.add(withoutLo);
                    set.add(withoutLo);
                 }

                 break;
              }// end if

              lo++;
              hi--;    
            } // end while

          } // end if
        
      
      
      } // end for       
            
      n--;
    
    }
   
  
   return false;

  }

  boolean checkPali(String s, int lo, int hi){
  
    while(lo < hi){
      if(s.charAt(lo) != s.charAt(hi))
        return false;
      
      lo++;
      hi--;
      
    }
    
    return true;
  
  }

============

public boolean makeItPali(String str, int n){


  public boolean makeItPali(String str){
    
    if(str == null || str.length() == 0)
       return true;
  
    int lo = 0;
    int hi = str.length() - 1;
  
    while(lo < hi){
    
      if(s.charAt(lo) != s.charAt(hi)){
         return checkPali(s, lo,  hi - 1) || checkPali(s, lo + 1,  hi);      
      }
      
      lo++;
      hi--;    
    }
  
   return true;

  }

  boolean checkPali(String s, int lo, int hi){
  
    while(lo < hi){
      if(s.charAt(lo) != s.charAt(hi))
        return false;
      
      lo++;
      hi--;
      
    }
    
    return true;
  
  }