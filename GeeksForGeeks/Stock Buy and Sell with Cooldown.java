class Solution {
    // recursion
    // public int maxProfit(int[] arr) {
    //     return recur(0, true, arr);
    // }
    // int recur(int i , boolean buy, int[] arr){
    //     if(i>=arr.length){
    //         return 0;
    //     }
    //     if(buy){
    //         int buystock = recur(i+1, false, arr) - arr[i];
    //         int dontbuystock = recur(i+1, true, arr);
    //         return Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = arr[i] + recur(i+2, true, arr);
    //         int dontsellstock = recur(i+1, false, arr);
    //         return Math.max(sellstock, dontsellstock);
    //     }
    // }

    // memoization
    // public int maxProfit(int[] arr) {
    //     int[][] dp = new int[arr.length+1][2];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(0, 1, arr, dp);
    // }
    // int recur(int i , int buy, int[] arr, int[][] dp){
    //     if(i>=arr.length){
    //         return 0;
    //     }
    //     if(dp[i][buy]!=-1){
    //         return dp[i][buy];
    //     }
    //     if(buy==1){
    //         int buystock = recur(i+1, 0, arr, dp) - arr[i];
    //         int dontbuystock = recur(i+1, 1, arr, dp);
    //         return dp[i][buy] = Math.max(buystock, dontbuystock);
    //     }else{
    //         int sellstock = arr[i] + recur(i+2, 1, arr, dp);
    //         int dontsellstock = recur(i+1, 0, arr, dp);
    //         return dp[i][buy] = Math.max(sellstock, dontsellstock);
    //     }
    // }

    // tabultaion
    // public int maxProfit(int[] arr) {
    //     int[][] dp = new int[arr.length+2][2];
    //     int n = arr.length;
    //     dp[n+1][0]=0;
    //     dp[n+1][1]=0;
    //     dp[n][0]=0;
    //     dp[n][1]=0;

    //     for(int i = n-1; i>=0; i--){
    //         for(int buy = 0; buy<2; buy++){
    //             if(buy==1){
    //                 int buystock = dp[i+1][0] - arr[i];
    //                 int dontbuystock = dp[i+1][1];
    //                 dp[i][buy] = Math.max(buystock, dontbuystock);
    //             }else{
    //                 int sellstock = arr[i] + dp[i+2][1];
    //                 int dontsellstock = dp[i+1][0];
    //                 dp[i][buy] = Math.max(sellstock, dontsellstock);
    //             }
    //         }
    //     }

    //     return dp[0][1];
    // }

    // space optimization
    public int maxProfit(int[] arr) {
        int[] ahead2 = new int[2];
        int[] ahead1 = new int[2];
        int[] curr = new int[2];
        int n = arr.length;
        ahead2[0]=0;
        ahead2[1]=0;
        ahead1[0]=0;
        ahead1[1]=0;

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                if(buy==1){
                    int buystock = ahead1[0] - arr[i];
                    int dontbuystock = ahead1[1];
                    curr[buy] = Math.max(buystock, dontbuystock);
                }else{
                    int sellstock = arr[i] + ahead2[1];
                    int dontsellstock = ahead1[0];
                    curr[buy] = Math.max(sellstock, dontsellstock);
                }
            }
            ahead2 = ahead1;
            ahead1 = curr;
            curr = new int[2];
        }

        return ahead1[1];
    }
}
