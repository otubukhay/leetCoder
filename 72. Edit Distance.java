  /*
		Let following be the function definition :-

		f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
		Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
		f(i, j) = f(i - 1, j - 1)
		Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
		f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
		f(i, j - 1) represents insert operation
		f(i - 1, j) represents delete operation
		f(i - 1, j - 1) represents replace operation
  */
  public int minDistance(String word1, String word2)
  {       
         int[][] dp = new int[word1.length() + 1][word2.length() + 1];        
         for(int i = 0 ;i < dp.length;i++)
         {
            dp[i][0] = i;
         }
        
         for(int i = 0; i < dp[0].length; i++)
         {
            dp[0][i] = i;
         }
        
         for(int i = 1; i < dp.length;i++)
         {
             for(int j = 1; j < dp[i].length; j++)
             {                 
                   if(word1.charAt(i - 1) == word2.charAt(j - 1))
                   {
                         dp[i][j] = dp[i - 1][j - 1] ;
                   }
                   else
                   {
                       dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]), dp[i - 1][j - 1]);
                   }                  
               }             
         }      
        
       return dp[word1.length()][word2.length()];     
    }