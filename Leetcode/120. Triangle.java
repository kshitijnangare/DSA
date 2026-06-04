class Solution {
    // basic recursion
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     return recursion(0,0, triangle, n);
    // }
    // int recursion(int i, int j, List<List<Integer>> triangle, int n){
    //     if(i==n-1){
    //         return triangle.get(i).get(j);
    //     }
    //     int down = recursion(i+1, j, triangle, n);
    //     int diagonal = recursion(i+1, j+1, triangle, n);
    //     return triangle.get(i).get(j) + Math.min(down, diagonal);
    // }

    // memoization
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     int[][] dp = new int[n][n];
    //     for(int[] row : dp){
    //         Arrays.fill(row, Integer.MIN_VALUE);
    //     }
    //     return memo(0,0, triangle, n, dp);
    // }
    // int memo(int i, int j, List<List<Integer>> triangle, int n, int[][] dp){
    //     if(i==n-1){
    //         return triangle.get(i).get(j);
    //     }
    //     if(dp[i][j]!=Integer.MIN_VALUE){
    //         return dp[i][j];
    //     }
    //     int down = memo(i+1, j, triangle, n, dp);
    //     int diagonal = memo(i+1, j+1, triangle, n, dp);
    //     return dp[i][j]=triangle.get(i).get(j) + Math.min(down, diagonal);
    // }

    // Tabulation

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        //base case
        for(int j = 0; j<n; j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i = n-2; i>=0; i--){
            for(int j = i; j>=0; j--){
                int up = dp[i+1][j];
                int diagonal = dp[i+1][j+1];
                dp[i][j]=triangle.get(i).get(j) + Math.min(up, diagonal);
            }
        }
        return dp[0][0];
    }
}