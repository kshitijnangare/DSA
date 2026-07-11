class Solution {
    // recursion
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     return recur(0, 1, 2, prices);
    // }
    // int recur(int i , int buy, int cap, int[] prices){
    //     if(cap==0){return 0;}
    //     if(i==prices.length){return 0;}

    //     if(buy==1){
    //         int buystock = recur(i+1, 0, cap, prices) - prices[i];
    //         int dontbuystock = recur(i+1, 1, cap, prices);
    //         return Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = recur(i+1, 1, cap-1, prices) + prices[i];
    //         int dontsellstock = recur(i+1, 0, cap, prices);
    //         return Math.max(sellstock, dontsellstock);
    //     }
    // }

    // memoization
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int cap = 2;
    //     int[][][] dp = new int[n+1][2][cap+1];
    //     for(int[][] rows: dp){
    //         for(int[] row: rows){
    //             Arrays.fill(row, -1);
    //         }
    //     }
    //     return recur(0, 1, 2, prices, dp);
    // }
    // int recur(int i , int buy, int cap, int[] prices, int[][][] dp){
    //     if(cap==0){return 0;}
    //     if(i==prices.length){return 0;}
        
    //     if(dp[i][buy][cap]!=-1){
    //         return dp[i][buy][cap];
    //     }

    //     if(buy==1){
    //         int buystock = recur(i+1, 0, cap, prices, dp) - prices[i];
    //         int dontbuystock = recur(i+1, 1, cap, prices, dp);
    //         return dp[i][buy][cap]=Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = recur(i+1, 1, cap-1, prices, dp) + prices[i];
    //         int dontsellstock = recur(i+1, 0, cap, prices, dp);
    //         return dp[i][buy][cap]=Math.max(sellstock, dontsellstock);
    //     }
    // }

    // tabulation
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int cap = 2;
    //     int[][][] dp = new int[n+1][2][cap+1];
    //     for(int i =0; i<=n; i++){
    //         for(int buy = 0; buy<2; buy++){
    //             dp[i][buy][0]=0;
    //         }
    //     }

    //     for(int buy = 0; buy<2; buy++){
    //         for(int c = cap; c>=0; c--){
    //             dp[0][buy][cap]=0;
    //         }
    //     }

    //     for(int i = n-1; i>=0; i--){
    //         for(int buy = 0; buy<2; buy++){
    //             for(int c = 1; c<=cap; c++){
    //                 if(buy==1){
    //                     int buystock = dp[i+1][0][c] - prices[i];
    //                     int dontbuystock = dp[i+1][1][c];
    //                     dp[i][buy][c]=Math.max(buystock, dontbuystock);
    //                 }else{
    //                     int sellstock = dp[i+1][1][c-1] + prices[i];
    //                     int dontsellstock = dp[i+1][0][c];
    //                     dp[i][buy][c]=Math.max(sellstock, dontsellstock);
    //                 }
    //             }
    //         }
    //     }

    //     return dp[0][1][2];
    // }


    // space optimization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        // int[][][] dp = new int[n+1][2][cap+1];
        int[][] ahead = new int[2][cap+1];
        int[][] curr = new int[2][cap+1];
        for(int i =0; i<=n; i++){
            for(int buy = 0; buy<2; buy++){
                ahead[buy][0]=0;
            }
        }

        for(int buy = 0; buy<2; buy++){
            for(int c = cap; c>=0; c--){
                ahead[buy][c]=0;
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                for(int c = 1; c<=cap; c++){
                    if(buy==1){
                        int buystock = ahead[0][c] - prices[i];
                        int dontbuystock = ahead[1][c];
                        curr[buy][c]=Math.max(buystock, dontbuystock);
                    }else{
                        int sellstock = ahead[1][c-1] + prices[i];
                        int dontsellstock = ahead[0][c];
                        curr[buy][c]=Math.max(sellstock, dontsellstock);
                    }
                }
            }
            ahead = curr;
        }

        return ahead[1][2];
    }
}