class Solution {
    // plain recursion
    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();
    //     return recur(n-1, m-1, word1, word2);
    // }
    // int recur(int i, int j, String s1, String s2){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2){
    //         return 0 + recur(i-1, j-1, s1, s2);
    //     }else{
    //         int insert = 1 + recur(i, j-1, s1, s2);
    //         int delete = 1 + recur(i-1, j, s1, s2);
    //         int replace = 1 + recur(i-1, j-1, s1, s2);
    //         return Math.min(insert, Math.min(delete, replace));
    //     }
    // }


    // memoization
    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, m-1, word1, word2, dp);
    // }
    // int recur(int i, int j, String s1, String s2, int[][] dp){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2){
    //         return dp[i][j]=0 + recur(i-1, j-1, s1, s2,dp);
    //     }else{
    //         int insert = 1 + recur(i, j-1, s1, s2,dp);
    //         int delete = 1 + recur(i-1, j, s1, s2,dp);
    //         int replace = 1 + recur(i-1, j-1, s1, s2,dp);
    //         return dp[i][j]=Math.min(insert, Math.min(delete, replace));
    //     }
    // }


    // Tabulation
     public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int offset = 1;
        int[][] dp = new int[n+offset][m+offset];
        
        for(int j = -1; j<m; j++){
            dp[-1+offset][j+offset]=j+1;
        }
        for(int i = -1; i<n; i++){
            dp[i+offset][-1+offset]=i+1;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset]=0+dp[i-1+offset][j-1+offset];
                }else{
                    int insert = 1 + dp[i+offset][j-1+offset];
                    int delete = 1 + dp[i-1+offset][j+offset];
                    int replace = 1 + dp[i-1+offset][j-1+offset];
                    dp[i+offset][j+offset]=Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n-1+offset][m-1+offset];
    }
}