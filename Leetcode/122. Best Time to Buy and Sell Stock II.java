class Solution {
    // recursion
    // public int maxProfit(int[] prices) {
    //     return recur(0, true, prices);
    // }
    // int recur(int i , boolean buy, int[] prices){
    //     if(i==prices.length){
    //         return 0;
    //     }
    //     if(buy){
    //         int buystock = recur(i+1, false, prices) - prices[i];
    //         int dontbuystock = recur(i+1, true, prices);
    //         return Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = prices[i] + recur(i+1, true, prices);
    //         int dontsellstock = recur(i+1, false, prices);
    //         return Math.max(sellstock, dontsellstock);
    //     }
    // }

    // memoization
    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length][2];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(0, 1, prices, dp);
    // }
    // int recur(int i , int buy, int[] prices, int[][] dp){
    //     if(i==prices.length){
    //         return 0;
    //     }
    //     if(dp[i][buy]!=-1){
    //         return dp[i][buy];
    //     }
    //     if(buy==1){
    //         int buystock = recur(i+1, 0, prices, dp) - prices[i];
    //         int dontbuystock = recur(i+1, 1, prices, dp);
    //         return dp[i][buy] = Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = prices[i] + recur(i+1, 1, prices, dp);
    //         int dontsellstock = recur(i+1, 0, prices, dp);
    //         return dp[i][buy] = Math.max(sellstock, dontsellstock);
    //     }
    // }

    // tabultaion
    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length+1][2];
    //     int n = prices.length;
    //     dp[n][0]=0;
    //     dp[n][1]=0;

    //     for(int i = n-1; i>=0; i--){
    //         for(int buy = 0; buy<2; buy++){
    //             if(buy==1){
    //                 int buystock = dp[i+1][0] - prices[i];
    //                 int dontbuystock = dp[i+1][1];
    //                 dp[i][buy] = Math.max(buystock, dontbuystock);
    //             }else{
    //                 int sellstock = prices[i] + dp[i+1][1];
    //                 int dontsellstock = dp[i+1][0];
    //                 dp[i][buy] = Math.max(sellstock, dontsellstock);
    //             }
    //         }
    //     }

    //     return dp[0][1];
    // }

    // normal no dynamic programming needed
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}