public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];
        
        for(int bagwt=0; bagwt<=w; bagwt++){
            dp[0][bagwt]= (bagwt/weight[0]) * profit[0];
        }
        
        for(int i = 0; i<n; i++){
            dp[i][0]=0;
        }
        
        for(int i = 1; i<n; i++){
            for(int bagwt = 1; bagwt<=w; bagwt++){
                int notPick = 0 + dp[i-1][bagwt];
                int pick = 0;
                if(bagwt>=weight[i]){
                    pick = profit[i] + dp[i][bagwt-weight[i]];
                }
                dp[i][bagwt] = Math.max(notPick, pick);
            }
        }
        return dp[n-1][w];
    }
}   