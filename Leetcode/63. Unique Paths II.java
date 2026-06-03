class Solution {
     //Basic Recursion

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     return recursion(m-1,n-1, obstacleGrid);
    // }
    // int recursion(int i, int j, int[][] obstacleGrid){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(obstacleGrid[i][j]==1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     int up = recursion(i, j-1, obstacleGrid);
    //     int left = recursion(i-1, j, obstacleGrid);
    //     return up+left;
    // }

    // Memoization --> converted from recursion
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] dp = new int[m][n];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recursion(m-1,n-1, dp, obstacleGrid);
    // }
    // int recursion(int i, int j, int[][] dp, int[][] obstacleGrid){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(obstacleGrid[i][j]==1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up = recursion(i, j-1, dp, obstacleGrid);
    //     int left = recursion(i-1, j, dp, obstacleGrid);
    //     return dp[i][j]=up+left;
    // }

    // Tabulation
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     // step 1: declare the array of DP
    //     int[][] dp = new int[m][n];

    //     // step 2: express all states in the form of loops
    //     for(int i = 0; i<m; i++){
    //         for(int j = 0; j<n; j++){
    //             if(obstacleGrid[i][j]==1){
    //                 dp[i][j] = 0;
    //             }else if(i==0 && j==0){ // part of step 1: delare and express base case in form of dp array
    //                 dp[i][j]=1;
    //             }else{
    //                 // VVIMP*** step 3: copy the recurrence as it is. replace function name with dp and keep the indexes as it is.
    //                 int up = j>0 ? dp[i][j-1] : 0;
    //                 int left = i>0 ? dp[i-1][j] : 0;
    //                 dp[i][j] = up+left;
    //             }
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }

    // Space optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        Arrays.fill(prev, 0);
        int[] curr = prev;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    curr[j]=0;
                }else if(i==0 && j==0){ 
                    curr[j]=1;
                }else{
                    int up = j>0 ? curr[j-1] : 0;
                    int left = prev[j];
                    curr[j] = up+left;
                    prev=curr;
                }
            }
        }
        return curr[n-1];
    }
}