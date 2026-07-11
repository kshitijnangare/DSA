public class Solution {
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int[][] dp = new int[prices.length+1][2];
        dp[n][0]=0;
        dp[n][1]=0;

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                if(buy==1){
                    int buystock = dp[i+1][0] - prices[i];
                    int dontbuystock = dp[i+1][1];
                    dp[i][buy] = Math.max(buystock, dontbuystock);
                }else{
                    int sellstock = prices[i] + dp[i+1][1] - fee;
                    int dontsellstock = dp[i+1][0];
                    dp[i][buy] = Math.max(sellstock, dontsellstock);
                }
            }
        }

        return dp[0][1];
    }
}