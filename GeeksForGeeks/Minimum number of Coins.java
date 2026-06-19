class Solution {
    // int MAX = 1000000009;
    // public int findMin(int n) {
    //     // code here
    //     int[] coins = { 1, 2, 5, 10 };
    //     return coinChange(coins, n);
    // }
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int i = 0; i<n; i++){
    //         dp[i][0] = 0;
    //     }

    //     for(int a = 0; a<=amount; a++){
    //         if(a % coins[0] == 0){
    //             dp[0][a] =  a/coins[0];
    //         }else{
    //             dp[0][a] = MAX;
    //         }
    //     }

    //     for(int i = 1; i<n; i++){
    //         for(int a = 1; a<=amount; a++){
    //             int notPickLength = 0 + dp[i-1][a];
    //             int pickLength = MAX;
    //             if(a >= coins[i]){
    //                 pickLength = 1 + dp[i][a-coins[i]] ;
    //             }
    //             dp[i][a] = Math.min(pickLength, notPickLength);
    //         }
    //     }

    //     if(dp[n-1][amount] >= MAX){
    //         return -1;
    //     }
    //     return dp[n-1][amount];
    // }
    
    public int findMin(int n) {
        int count = 0; 
        int[] denomination = {1, 2, 5, 10}; 
        
        for (int i = denomination.length - 1; i >= 0; i--) {
            
            // Find denominations
            count+=n/denomination[i];
            n=n%denomination[i];
        }
        return count; 
    }
    
}
