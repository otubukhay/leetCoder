 public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) 
    {
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) 
        {
            nodes.add(i);
        }

        for (int val : leftChild) 
        {
            if (val != -1) 
            {
                if (!nodes.contains(val))  // appears many times. Was removed before
                {                    
                    return false;
                }
                nodes.remove(val);
            }
        }
        
        for (int val : rightChild) 
        {
            if (val != -1) 
            {
                if (!nodes.contains(val))   // appears many times. Was removed before
                {                  
                    return false;
                }
                nodes.remove(val);
            }
        }

        if (nodes.size() != 1) 
        {
            return false;
        }

        int root = nodes.iterator().next();
        int howManyReached = 0;        
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) 
        {
            int node = q.remove();
            howManyReached++;
            
            int left = leftChild[node];
            if (left != -1) 
            {
                q.add(left);
            }
            
            int right = rightChild[node];
            if (right != -1)
            {
                q.add(right);
            }
        }
        return howManyReached == n;
    }