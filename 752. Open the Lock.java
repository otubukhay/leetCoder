/*
Time Complexity: O(N^2 * A^N + D) where A is the number of digits in our alphabet, 
N is the number of digits in the lock, and DD is the size of deadends. 
We might visit every lock combination, plus we need to instantiate our set dead. When we visit every lock combination, we spend O(N^2) time enumerating through 
and constructing each node. 
Space Complexity: O(A^N + D), for the queue and the set dead.

*/
class Solution
{
    public int openLock(String[] deadends, String target)
    {
        Queue<String> q = new LinkedList<>();
       
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        
		int level = 0;        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int j = 1; j <= size; j++)
            {
                String currentLock = q.poll();
                if(currentLock.equals(target))
				{
                    return level;
				}
                
                if(!deads.contains(currentLock))
                {
                    for(String nextLocks : getNextLocks(currentLock))
                    {
                        if(!visited.contains(nextLocks))
                        {
                            q.offer(nextLocks);
                            visited.add(nextLocks);
                        }
                    }
                }
            }
            
            level ++;
        }
        
        return -1;
    }
    
    private List<String> getNextLocks(String lock)
    {
        List<String> locks = new ArrayList();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            char c = arr[i];            
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        
        return locks;
    }
}