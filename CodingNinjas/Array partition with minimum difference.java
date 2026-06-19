import java.util.*;
public class Solution {
    // tabulation method first
    // public static int minSubsetSumDifference(int []arr, int n) {
    //     // Write your code here.
    //     int totalsum = 00;
    //     for(int x: arr){
    //         totalsum+=x;
    //     }
    //     boolean[][] dp = new boolean[n][totalsum+1];
    //     for(int i = 0; i<n; i++){
    //         dp[i][0]=true;
    //     }
    //     dp[0][arr[0]]=true;
    //     int target = totalsum;
    //     for(int i = 1; i<n; i++){
    //         for(int t = 1; t<=target; t++){
    //             boolean pick = false;
    //             if(t-arr[i]>=0){
    //                 pick = dp[i-1][t-arr[i]];
    //             }
    //             boolean notPick = dp[i-1][t];
    //             dp[i][t] = pick || notPick;
    //         }
    //     }

    //     int ans = Integer.MAX_VALUE;
    //     for(int t = 0; t<=totalsum; t++){
    //         if(dp[n-1][t] == true){
    //             int diff = Math.abs( t - (totalsum-t) );
    //             ans = Math.min(ans, diff );
    //         }
    //     }
    //     return ans;
    // }

    // memoization
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int totalsum = 00;
        for(int x: arr){
            totalsum+=x;
        }
        int[][] dp = new int[n][totalsum+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(n-1, 0, totalsum, arr, dp);
    }

    public static int recur(int i, int currsum, int totalsum, int[] arr, int[][] dp){
        if(i<0){
            int subset1 = currsum;
            int subset2 = totalsum-currsum;
            return Math.abs(subset1-subset2);
        }
        if(dp[i][currsum]!=-1){
            return dp[i][currsum];
        }
        int pick = recur(i-1, currsum+arr[i], totalsum, arr, dp);
        int notPick = recur(i-1, currsum, totalsum, arr, dp);
        return dp[i][currsum] = Math.min(pick, notPick);
    }
}