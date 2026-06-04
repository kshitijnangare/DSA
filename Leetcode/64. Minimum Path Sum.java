class Solution {
    // basic recurssion
    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     return recursion(n-1, m-1, grid);
    // }
    // int recursion(int i, int j, int[][] grid){
    //     if(i==0 && j==0){
    //         return grid[0][0];
    //     }
    //     if(i<0 || j<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     int up = recursion(i-1, j, grid);
    //     int left = recursion(i, j-1, grid);
    //     return grid[i][j] + Math.min(up,left);
    // }

    // memoization

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return recursion(n-1, m-1, grid, dp);
    }
    int recursion(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = recursion(i-1, j, grid, dp);
        int left = recursion(i, j-1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up,left);
    }

    // Tabulation

    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     int[][] dp = new int[n][m];
    //     dp[0][0] = grid[0][0];

    //     for(int i = 0; i<n; i++){
    //         for(int j = 0; j<m; j++){
    //             if(i==0 && j==0){
    //                 dp[i][j] = grid[0][0];
    //             }else{
    //                 int up = i>0 ? dp[i-1][j] : Integer.MAX_VALUE;
    //                 int left = j>0 ? dp[i][j-1] : Integer.MAX_VALUE;
    //                 dp[i][j] = grid[i][j] + Math.min(up, left);
    //             }
               
    //         }
    //     }
    //     return dp[n-1][m-1];
    // }

}