class Solution 
{
  private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
  public int minKnightMoves(int x, int y) 
  {
    x = Math.abs(x);
    y = Math.abs(y);

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});

    Set<String> visited = new HashSet<>();
    visited.add("0,0");

    int steps = 0;
    while (!queue.isEmpty()) 
	{
      int size = queue.size();
      for (int i = 0; i < size; i++) 
	  {
        int[] cur = queue.remove();
        int curX = cur[0];
        int curY = cur[1];
        if (curX == x && curY == y) 
		{
           return steps;
        }

        for (int[] d: DIRECTIONS) 
		{
          int newX = curX + d[0];
          int newY = curY + d[1];
          // If you remove this condition newX >= -1 && newY >= -1) this solution would give TLE.
          if (!visited.contains(newX + "," + newY) && newX >= -2 && newY >= -2) 
		  {
            queue.add(new int[] { newX, newY });
            visited.add(newX + "," + newY);
          }
        }
      }
      steps++;
    }
    return -1;
  }
}