public int numMusicPlaylists(int N, int L, int K) 
    {
        int MOD = 1_000_000_007;
        
        /*
         Let dp[i][j] be the number of playlists of length i that have exactly j unique songs. 
         We want dp[L][N], and it seems likely we can develop a recurrence for dp.
         i length of playlist we currently have
         j number of unique songs in current playlist
         
        */
        long[][] dp = new long[L + 1][N + 1]; 
        dp[0][0] = 1;
        
        /*
        Consider dp[i][j]. 
        Last song, we either played a song for the first time or we didn't. 
        If we did, then we had dp[i - 1][j - 1] * (N - j + 1) ways to choose it.
        If we didn't, then we repeated a previous song in dp[i-1][j] * max(j-K, 0) ways 
                                     (j of them, except the last K ones played are banned.)
        */
        for(int i = 1; i <= L; ++i)
        {
            for(int j = 1; j <= N; ++j) 
            {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1); // choose a new song
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0); // repeat a previous song
                dp[i][j] %= MOD;
            }
        }

        return (int) dp[L][N];
    }