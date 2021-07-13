public boolean isValidPalindrome(String s, int k) 
{
    int lps = longestPalindromeSubseq(s);
    return (k >= s.length() - lps);    
}

public int longestPalindromeSubseq(String s) {
        // write your code here

        int n = s.length();
        if(n <= 1)
          return n;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
        {
           dp[i][i] = 1;
        }

        for(int i = 0; i < n - 1; i++)
        {
           dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ?  2 : 1;
        }

        for(int len = 3; len <= n; len++)
        {
            for(int start = 0; start < n; start++)
            {
                int end = start + len - 1;
                if(end < n)
                {
                    if(s.charAt(start) == s.charAt(end))
                    {
                        dp[start][end] = 2 + dp[start + 1][end - 1];
                    }
                    else
                    {
                        dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }