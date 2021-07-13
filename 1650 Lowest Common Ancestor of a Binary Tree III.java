//Time = O(h) = O(logn),
//Space = O(n)
public Node lowestCommonAncestor(Node p, Node q)
{
     Set<Integer> set = buildSet(p);	 
	 return SearchSet(q, set);
}

private Node searchSet(Node cur, Set<Integer> set){
	if(cur == null)
		return null;
	
	if(set.contains(cur.val))
		return cur;
	
	return searchSet(cur.parent);	
}

private Set<Integer> buildSet(Node cur)
{
   if(cur == null)
      return  new HashSet<Integer>();
  
   Set<Integer> set = new HashSet();
   while(cur != null)
   {
	   set.add(cur.val);
	   cur = cur.parent;	   
   }
   
   return set;
}

********************************************************
********************************************************
//Time = O(h) = O(logn),
//Space = O(1)
 public Node lowestCommonAncestor(Node p, Node q) {
        
        Node pCopy = p;
        Node qCopy = q;
        
        while(qCopy != pCopy)
        {
            pCopy = (pCopy == null) ? q : pCopy.parent;    
            qCopy = (qCopy == null) ? p : qCopy.parent;
        }
        
        return qCopy;
    }