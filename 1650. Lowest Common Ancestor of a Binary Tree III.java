T = //O(logn), S = O(1)
public Node lowestCommonAncestor(Node p, Node q) 
   {
        Node a = p, b = q;
        while (a != b) 
        {
            a = (a == null) ? q : a.parent;
            b = (b == null) ? p : b.parent;    
        }
       
        return a;
    }
	
//Or build a set 