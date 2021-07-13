 public boolean canFinish(int numCourses, int[][] prerequisites) 
 {
        if (numCourses == 0 || prerequisites.length == 0)
            return true;
       
        int dependents[] = new int[numCourses];
        for (int[] pre : prerequisites)
            dependents[pre[0]]++;    

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (dependents[i] == 0)
                queue.add(i);
        
        int canFinishCount = queue.size(); 
        while (!queue.isEmpty()) 
        {
                int prerequisite = queue.remove(); 
                for (int[] pre : prerequisites)  
                {
                    if (pre[1] == prerequisite) 
                    { 
                        dependents[pre[0]]--;
                        if (dependents[pre[0]] == 0) 
                        {
                            canFinishCount++;
                            queue.add(pre[0]);
                        }
                    }
                }               
        }

        return (canFinishCount == numCourses);    
    }