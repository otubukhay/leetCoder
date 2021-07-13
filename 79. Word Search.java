class Solution 
{
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

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index) || board[i][j] == '#')
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
}