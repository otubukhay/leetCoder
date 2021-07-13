/*
Time Complexity: O(V + E) where V represents the number of vertices and E represents the number of edges. 
We pop each node exactly once from the zero in-degree queue and that gives us V
Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us EE. Hence, O(V + E)

Space Complexity: O(V + E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree.
In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. That gives us O(V).
Additionally, we also use the adjacency list to represent our graph initially.
 The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value. 
 Hence, O(E). So, the overall space complexity is O(V + E).
*/
class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        if(prerequisites == null)
            return null;
        
        int[] dependents = new int[numCourses];
        for(int[] pre : prerequisites)
		{
            dependents[pre[0]]++;
		}
        
        Queue<Integer> q = new LinkedList();        
        int[] res = new int[numCourses];  
        int i = 0;
        
        for(int index = 0; index < dependents.length; index++)
        {
            if(dependents[index] == 0)
            {
               q.add(index);
               res[i++] = index;                   
            }
        }
        
        while(!q.isEmpty())
        {           
           
                int cur = q.poll();                           
                for(int[] pre : prerequisites)
                {                        
                   if(pre[1] == cur)
                   {
                      dependents[pre[0]]--;
                      if(dependents[pre[0]] == 0)
                      {
                         q.add(pre[0]);
                         res[i++] = pre[0];     
                      }
                   }
                        
                }              
        }             
        
        return (i == numCourses) ? res : new int[0];            
    }
    
}