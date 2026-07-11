class Solution {
    public int maxProfit(int arr[], int k) {
        // Code here
        int[][] dp = new int[arr.length+1][2];
        int n = arr.length;
        dp[n][0]=0;
        dp[n][1]=0;

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                if(buy==1){
                    int buystock = dp[i+1][0] - arr[i];
                    int dontbuystock = dp[i+1][1];
                    dp[i][buy] = Math.max(buystock, dontbuystock);
                }else{
                    int sellstock = arr[i] + dp[i+1][1] - k;
                    int dontsellstock = dp[i+1][0];
                    dp[i][buy] = Math.max(sellstock, dontsellstock);
                }
            }
        }

        return dp[0][1];
    }
}