public List<String> removeSubfolders1(String[] folder) 
    {
       Arrays.sort(folder);
       List<String> result = new  ArrayList<>();      
       for(String currentFolder : folder)
       {           
           if(result.isEmpty())
           {
               result.add(currentFolder);
           }
           else
           {
               String last = result.get(result.size() - 1);    
               if(!currentFolder.startsWith(last + "/"))
               {
                  result.add(currentFolder);
               }
           }
       }
        
       return result;
    }


*******************************************************************************	
  
  public List<String> removeSubfolders(String[] folder) 
     {
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        Set<String> seen = new HashSet<>();       
        for (String f : folder) 
        {
            boolean isFolderValid = true;
            for(int i = 2; i < f.length(); ++i)
            {
                if(f.charAt(i) == '/' && seen.contains(f.substring(0, i)))
                { 
                   isFolderValid = false;
                   break;
                }
            }
            
            if(isFolderValid)
            {
                seen.add(f);
            }
        }
         
        return new ArrayList<>(seen);
    }