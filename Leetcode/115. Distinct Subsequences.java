class Solution {
    // plain recursion
    // public int numDistinct(String s, String t) {
    //     int n = s.length();
    //     int m = t.length();
    //     return recur(n-1, m-1, s, t);   
    // }
    // int recur(int i, int j, String s1, String s2){
    //     if(j<0){
    //         return 1;
    //     }
    //     if(i<0){
    //         return 0;
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2){
    //         return recur(i-1,j-1,s1,s2) + recur(i-1,j,s1,s2);
    //     }else{
    //         return recur(i-1,j,s1,s2);
    //     }
    // }


    // memoization
    // public int numDistinct(String s, String t) {
    //     int n = s.length();
    //     int m = t.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, m-1, s, t, dp);   
    // }
    // int recur(int i, int j, String s1, String s2, int[][] dp){
    //     if(j<0){
    //         return 1;
    //     }
    //     if(i<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2){
    //         return dp[i][j]=recur(i-1,j-1,s1,s2,dp) + recur(i-1,j,s1,s2,dp);
    //     }else{
    //         return dp[i][j]=recur(i-1,j,s1,s2, dp);
    //     }
    // }

    // tabulation
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int offset = 1;
        int[][] dp = new int[n+offset][m+offset];
        for(int i = -1; i<n; i++){
            dp[i+offset][-1+offset]=1;
        }
        for(int j = 0; j<m; j++){
            dp[-1+offset][j+offset]=0;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = s.charAt(i);
                char c2 = t.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset]=dp[i-1+offset][j-1+offset] + dp[i-1+offset][j+offset];
                }else{
                    dp[i+offset][j+offset]=dp[i-1+offset][j+offset];
                }
            }
        }
        return dp[n-1+offset][m-1+offset];
    }
}