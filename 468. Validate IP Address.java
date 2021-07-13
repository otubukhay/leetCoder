 public static String validIPAddress(String IP) 
     {
        String[] ipv4 = IP.split("\\.",-1);
        String[] ipv6 = IP.split("\\:",-1);       
       
        if(ipv4.length == 4)
        {
            for(String s : ipv4) 
            {
                if(!isIPv4(s))
                {
                    return "Neither"; 
                }
            }
            return "IPv4";
        }
         
        if(ipv6.length == 8)
        {
            for(String s : ipv6)
            {
                if(!isIPv6(s)) 
                {
                   return "Neither";
                }
            }
            
            return "IPv6";
        }
         
        return "Neither";
    }
   
    
    public static boolean isIPv4 (String s)
    {
         try
         { 
             return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
         }
         catch (NumberFormatException e)
         {
             return false;
         }
    }
    
    public static boolean isIPv6 (String s)
    {        
        try
        {
            return s.length() <= 4 && Integer.parseInt(s, 16) >= 0;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }