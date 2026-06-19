import java.util.* ;
import java.io.*; 

public class Solution{
    // static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

    //         /* Your class should be named Solution
    //         * Don't write main().
    //         * Don't read input, it is passed as function argument.
    //         * Change in the given tree itself.
    //         * No need to return or print the output.
    //         * Taking input and printing output is handled automatically.
    //         */
    //     int[][] dp = new int[n][maxWeight+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, maxWeight, weight, value, dp);
    // }
    // static int recur(int i, int w, int[] weight, int[] value, int[][] dp){
    //     if(i==0){
    //         if(weight[i]<=w){
    //             return value[i];
    //         }else{
    //             return 0;
    //         }
    //     }

    //     if(dp[i][w]!=-1){
    //         return dp[i][w];
    //     }


    //     int notPick= 0 + recur(i-1, w, weight, value, dp);
    //     int pick = Integer.MIN_VALUE;
    //     if(weight[i]<=w){
    //         pick = value[i] + recur(i-1, w-weight[i], weight, value, dp);
    //     }
    //     return dp[i][w] = Math.max(pick, notPick);
    // }


    // tabulation
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int w = 0; w<=maxWeight; w++){
            if(weight[0]<=w){
                dp[0][w] = value[0];
            }
        }

        for(int i = 1; i<n; i++){
            for(int w = 0; w<=maxWeight; w++){
                int notPick= 0 + dp[i-1][w];
                int pick = Integer.MIN_VALUE;
                if(weight[i]<=w){
                    pick = value[i] + dp[i-1][w-weight[i]];
                }
                dp[i][w] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][maxWeight];
    }
}