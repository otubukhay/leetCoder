 public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
       
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                map[i][j] = (i == 0 || j == 0) ? 1 :  map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }