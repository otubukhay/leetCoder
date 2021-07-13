public boolean isOneEditDistance(String s, String t) 
{
        if(s.equals(t))
            return false;
            
        int ns = s.length();
        int nt = t.length();       
       
        if(Math.abs(ns - nt) > 1)
            return false;

        for (int i = 0; i < Math.min(ns, nt); i++)
        {
            if (s.charAt(i) != t.charAt(i)) 
            {
                if (ns == nt) 
                {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } 
                else if(nt > ns) 
                {
                    return s.substring(i).equals(t.substring(i + 1));
                }
                else
                {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }

        return true;
    }