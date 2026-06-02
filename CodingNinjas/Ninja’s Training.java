public class Solution {

    // memoization
    
    // public static int ninjaTraining(int n, int points[][]) {
    //     if(n==1){
    //         return Math.max(Math.max(points[0][0], points[0][1]), points[0][2] );
    //     }
        
    //     int[][] dp = new int[n][4];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1);
    //     }
    //     dp[0][0] = Math.max(points[0][1], points[0][2]);
    //     dp[0][1] = Math.max(points[0][0], points[0][2]);
    //     dp[0][2] = Math.max(points[0][1], points[0][1]);
    //     dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);
        
    //     return recur(n-1, 3, mat, dp);
    // }
    
    // static int recur(int day, int lastPerformed, int[][] mat, int[][] dp){
    //     if(day==0){
    //         int max = 0;
    //         for(int i = 0; i<=2; i++){
    //             if(lastPerformed!=i){
    //                 max = Math.max(max, points[day][i]);
    //             }
    //         }
    //         return max;
    //     }
    //     if(dp[day][lastPerformed]!=-1){
    //         return dp[day][lastPerformed];
    //     }
        
    //     int max = 0;
    //     for(int i = 0; i<=2; i++){
    //         if(lastPerformed!=i){
    //             int currPoints = points[day][i] + recur(day-1, i, mat, dp);
    //             max = Math.max(currPoints,max);
    //         }
    //     }
    //     return dp[day][lastPerformed] = max;
    // }
    
    // tabulation
    
    // public static int ninjaTraining(int n, int points[][]) {
    //     if(n==1){
    //         return Math.max(Math.max(points[0][0], points[0][1]), points[0][2] );
    //     }
        
    //     int[][] dp = new int[n][4];
    //     for(int[] r: dp){
    //         Arrays.fill(r, -1);
    //     }
    //     dp[0][0] = Math.max(points[0][1], points[0][2]);
    //     dp[0][1] = Math.max(points[0][0], points[0][2]);
    //     dp[0][2] = Math.max(points[0][0], points[0][1]);
    //     dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);
        
    //     for(int i = 1; i<n; i++){
    //         dp[i][0] = Math.max(points[i][1] + dp[i-1][1], points[i][2] + dp[i-1][2]);
    //         dp[i][1] = Math.max(points[i][0] + dp[i-1][0], points[i][2] + dp[i-1][2]);
    //         dp[i][2] = Math.max(points[i][1] + dp[i-1][1], points[i][0] + dp[i-1][0]);
    //         dp[i][3] = Math.max(points[i][0] + dp[i-1][0] ,Math.max(points[i][1] + dp[i-1][1], points[i][2] + dp[i-1][2]));
    //     }
    //     return dp[n-1][3];
    // }
    
    // space optimization
    
    public static int ninjaTraining(int n, int points[][]) {
        if(n==1){
            return Math.max(Math.max(points[0][0], points[0][1]), points[0][2] );
        }
        int prev00 = Math.max(points[0][1], points[0][2]);
        int prev01 = Math.max(points[0][0], points[0][2]);
        int prev02 = Math.max(points[0][0], points[0][1]);
        int prev03 = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);
        int curr03 = prev03;
        for(int i = 1; i<n; i++){
            int curr00 = Math.max(points[i][1] + prev01, points[i][2] + prev02);
            int curr01 = Math.max(points[i][0] + prev00, points[i][2] + prev02);
            int curr02 = Math.max(points[i][0] + prev00, points[i][1] + prev01);
            curr03 = Math.max(points[i][0] + prev00 ,Math.max(points[i][1] + prev01, points[i][2] + prev02));
            prev00=curr00;
            prev01=curr01;
            prev02=curr02;
            prev03=curr03;
        }
        return curr03;
    }

}