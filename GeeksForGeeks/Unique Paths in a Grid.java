class Solution {

   //Basic Recursion

    // public int uniquePaths(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     return recursion(n-1,m-1, grid);
    // }
    // int recursion(int i, int j, int[][] grid){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(grid[i][j]==1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     int up = recursion(i, j-1, grid);
    //     int left = recursion(i-1, j, grid);
    //     return up+left;
    // }

    // Memoization --> converted from recursion
    // public int uniquePaths(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] dp = new int[n][m];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recursion(n-1,m-1, dp, grid);
    // }
    // int recursion(int i, int j, int[][] dp, int[][] grid){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(grid[i][j]==1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up = recursion(i, j-1, dp, grid);
    //     int left = recursion(i-1, j, dp, grid);
    //     return dp[i][j]=up+left;
    // }

    // Tabulation
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // step 1: declare the array of DP
        int[][] dp = new int[n][m];

        // step 2: express all states in the form of loops
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1){
                    dp[i][j] = 0;
                }else if(i==0 && j==0){ // part of step 1: delare and express base case in form of dp array
                    dp[i][j]=1;
                }else{
                    // VVIMP*** step 3: copy the recurrence as it is. replace function name with dp and keep the indexes as it is.
                    int up = j>0 ? dp[i][j-1] : 0;
                    int left = i>0 ? dp[i-1][j] : 0;
                    dp[i][j] = up+left;
                }
            }
        }

        return dp[n-1][m-1];
    }

    // Space optimization
    // public int uniquePaths(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[] prev = new int[m];
    //     Arrays.fill(prev, 0);

    //     for(int i = 0; i<n; i++){
    //         int[] curr = new int[m];
    //         for(int j = 0; j<m; j++){
    //             if(grid[i][j]==1){
    //                 curr[j]=0;
    //             }else if(i==0 && j==0){ 
    //                 curr[j]=1;
    //             }else{
    //                 int up = j>0 ? curr[j-1] : 0;
    //                 int left = prev[j];
    //                 curr[j] = up+left;
    //             }
    //         }
    //         prev=curr;
    //     }
    //     return prev[m-1];
    // }
}