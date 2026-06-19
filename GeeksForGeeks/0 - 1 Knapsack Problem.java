class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][W+1];
        for(int bagwt = 0; bagwt<=W; bagwt++){
            if(bagwt>=wt[0]){
                dp[0][bagwt] = val[0];
            }
        }
        
        for(int i = 1; i<n; i++){
            for(int bagwt = 0; bagwt<=W; bagwt++){
                int notPick = 0 + dp[i-1][bagwt];
                int pick = Integer.MIN_VALUE;
                if(bagwt>=wt[i]){
                    pick = val[i] + dp[i-1][bagwt-wt[i]];
                }
                dp[i][bagwt]=Math.max(pick, notPick);
            }
        }
        
        return dp[n-1][W];
        
    }
}
