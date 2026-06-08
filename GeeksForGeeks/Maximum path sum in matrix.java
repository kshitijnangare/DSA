// User function Template for Java
class Solution {
    // recurr
    // public int maximumPath(int[][] mat) {
    //     // code here
    //     int n = mat.length;
    //     int m = mat[0].length;
    //     int max = 0;
    //     for(int j = 0; j<m; j++){
    //         max = Math.max(max, recur(n-1,j,mat, m) );
    //     }
    //     return max;
    // }
    // int recur(int i, int j, int[][] mat, int m){
    //     if(j<0 || j>=m){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(i==0){
    //         return mat[i][j];
    //     }
        
    //     int up = recur(i-1, j, mat, m);
    //     int rightUp = recur(i-1, j+1, mat, m);
    //     int leftUp = recur(i-1, j-1, mat, m);
    //     return mat[i][j] + Math.max(up, Math.max(leftUp, rightUp));
    // }
    
    // memo
    // public int maximumPath(int[][] mat) {
    //     // code here
    //     int n = mat.length;
    //     int m = mat[0].length;
    //     int[][] dp = new int[n][m];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     int max = 0;
    //     for(int j = 0; j<m; j++){
    //         max = Math.max(max, recur(n-1,j,dp,mat, m) );
    //     }
    //     return max;
    // }
    // int recur(int i, int j, int[][] dp, int[][] mat, int m){
    //     if(j<0 || j>=m){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(i==0){
    //         return mat[i][j];
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
        
    //     int up = recur(i-1, j, dp, mat, m);
    //     int rightUp = recur(i-1, j+1, dp, mat, m);
    //     int leftUp = recur(i-1, j-1, dp, mat, m);
    //     return dp[i][j] = mat[i][j] + Math.max(up, Math.max(leftUp, rightUp));
    // }
    
    // tabulation
     public int maximumPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        for(int j = 0; j<m; j++){
            dp[0][j] = mat[0][j];
        }
        
        int max = 0;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<m; j++){
                int k = j;
                int up = dp[i-1][k];
                int rightUp = j<m-1 ? dp[i-1][k+1] : Integer.MIN_VALUE;
                int leftUp = j>0 ? dp[i-1][k-1] : Integer.MIN_VALUE;
                dp[i][j] = mat[i][j] + Math.max(up, Math.max(leftUp, rightUp));
            }
        }
        
        for(int j: dp[n-1]){
            max = Math.max(max, j);
        }
        
        return max;
    }
    
    
    
}