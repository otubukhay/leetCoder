    /*
	Time Complexity : O(N + M), where N is a number of nodes (vertices) and M is a number of edges.
    Space Complexity : O(N). This space is occupied by the visited dictionary and in addition to that, 
	space would also be occupied by the queue since we are adopting the BFS approach here. 
	The space occupied by the queue would be equal to O(W) where W is the width of the graph. 
	Overall, the space complexity would be O(N).
	*/
	public Node cloneGraph(Node node) 
    {
        if(node == null)
            return node;
        
        Map<Node, Node> map = new HashMap();
        map.put(node, new Node(node.val));
        
        Queue<Node> q = new LinkedList();
        q.add(node);        
        
        while(!q.isEmpty())
        {
            Node currentParent = q.poll();
            Node clonedParent = map.get(currentParent);
            for(Node child : currentParent.neighbors)
            {
                Node clonedChild = map.getOrDefault(child, null);  
                if(clonedChild == null)
                {
                   clonedChild = new Node(child.val);
                   q.add(child);                   
                   map.put(child, clonedChild);                     
                }               
                
                clonedParent.neighbors.add(clonedChild);                
            }
        }
        
        return map.get(node);       
	}		