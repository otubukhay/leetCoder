 /*
 Complexity Analysis
Time Complexity: O(N), where N is the number of nodes in the given tree.
Space Complexity: O(N).
 */
 private List<Integer> result = new ArrayList();    
    private Map<TreeNode, TreeNode> parent = new HashMap();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        BuildParent(root, null);
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);        
        
        Set<TreeNode> seen =  new HashSet();
        seen.add(target);        
        
        int distance = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 1; i <= size ; i++)
            {
                    TreeNode cur = queue.remove();                    
                    if(distance == K)
                    {
                       result.add(cur.val);     
                       continue;
                    }

                    if(cur.left != null && !seen.contains(cur.left))
                    {
                         queue.add(cur.left);                        
                         seen.add(cur.left);
                    }

                    if(cur.right != null && !seen.contains(cur.right))
                    {
                         queue.add(cur.right);                        
                         seen.add(cur.right);
                    }

                    if(parent.containsKey(cur))
                    {
                         var curParent = parent.get(cur);                
                         if(curParent != null && !seen.contains(curParent))
                         {
                             queue.add(curParent);                          
                             seen.add(curParent);
                         }
                    }           
                
            }
            
            distance++;
        }
        
        
        return result;
    }
    
     public void BuildParent(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            BuildParent(node.left, node);
            BuildParent(node.right, node);
        }
    } 