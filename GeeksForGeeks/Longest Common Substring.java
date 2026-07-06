class Solution {
    // memoization code that will not work gives memory exceeded error. we need to 
    // move towards tabulatipn which will use 2d DP
    // public int longCommSubstr(String s1, String s2) {
    //     // code here
    //     int n = s1.length();
    //     int m = s2.length();
    //     int count = Math.min(n, m)+1;
    //     int[][][] dp = new int[n][m][count];
    //     for(int[][] rows: dp){
    //         for(int[] row: rows){        
    //             Arrays.fill(row, -1);
    //         }
    //     }
    //     return recur(n-1,m-1,0, s1, s2, dp);
    // }
    // int recur(int i , int j, int count, String s1, String s2, int[][][] dp){
    //     if(i<0 || j<0){
    //         return count;
    //     }
    //     if(dp[i][j][count]!=-1){
    //         return dp[i][j][count];
    //     }
        
    //     int match = count;
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2){
    //         match = recur(i-1, j-1, count+1, s1, s2, dp);
    //     }
    //     int skipFirst = recur(i-1, j, 0, s1, s2, dp);
    //     int skipSecond = recur(i, j-1, 0, s1, s2, dp);
    //     return dp[i][j][count] = Math.max(match, Math.max(skipFirst, skipSecond));
    // }
    
    
    // Tabulation 2D DP
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        int offset = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset] = 1 + dp[i-1+offset][j-1+offset];
                    ans = Math.max(ans, dp[i+offset][j+offset]);
                }else{
                    dp[i+offset][j+offset]=0;
                }
            }
        }
        return ans;
    }
    
}