    /*
	Time Complexity: O(N * 3 ^ L)
    where N is the number of cells in the board and L is the length of the word to be matched.
	For the backtracking function, initially we could have at most 4 directions to explore,
	but further the choices are reduced into 3 (since we won't go back to where we come from). 
	As a result, the execution trace after the first step could be visualized as a 3-ary tree, 
	each of the branches represent a potential exploration in the corresponding direction. 
	Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L 
	
	We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
    As a result, overall the time complexity of the algorithm would be O(N * 3 ^ L)
	Space Complexity: O(L) where L is the length of the word to be matched.
	The main consumption of the memory lies in the recursion call of the backtracking function. 
	The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).
	*/
	int m = -1;
    int n = -1;
    public boolean exist(char[][] board, String word) 
    {
         m = board.length;
         n = board[0].length;

        boolean result = false;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
               if(dfs(board, word, i, j, 0))
               {
                  return true;
               }
            }
        }
 
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int i, int j, int index)
    {
        if(index >= word.length())
            return true;        

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index))
        {
            return false;
        }
    
        board[i][j] = '#';           
        if(dfs(board, word, i - 1, j, index + 1)  || dfs(board, word, i + 1, j, index + 1)
            ||dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1))
        {
            return true;
        }
        
        board[i][j] = word.charAt(index);        
        return false;
    }