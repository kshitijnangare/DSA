class Solution {

    // 1. express in terms of index ( here i to iterate the coins arr will change
    // and the amount will be reduced at each selection that will change)
    // hence f(ind, amount)
    // 2. base cases will be i == 0 or amount == 0
    // if(amount == 0){return 0;} no need to do anything
    // if (i==0 ) then if(amount%coints[i]==0) return amount / coins[0] else Integer.MAX_VALUE

    // int notPickLength = 0 + f(ind-1, amount);
    // int pickLength = 0;
    // if(amount>=coins[ind]) pickLength = 1 + f(ind, amount - coins[ind])
    // return Math.min(pickLength, notPickLength); 


    // int MAX = 1000000000;

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int minCoins = recur(n-1, amount, coins);
    //     if(minCoins>=MAX){
    //         return -1;
    //     }else{
    //         return minCoins;
    //     }
    // }
    // int recur(int i, int amount, int[] coins){
    //     if(amount==0){
    //         return 0;
    //     }
    //     if(i==0){
    //         if(amount % coins[i] == 0){
    //             return amount/coins[i];
    //         }else{
    //             return MAX;
    //         }
    //     }

    //     int notPickLength = 0 + recur(i-1, amount, coins);
    //     int pickLength = MAX;
    //     if(amount >= coins[i]){
    //         pickLength = 1 + recur(i, amount-coins[i], coins);
    //     }
    //     return Math.min(pickLength, notPickLength);
    // }

    
    // memoization
    // int MAX = 1000000000;

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }

    //     int minCoins = recur(n-1, amount, coins, dp);
    //     if(minCoins>=MAX){
    //         return -1;
    //     }else{
    //         return minCoins;
    //     }
    // }
    // int recur(int i, int amount, int[] coins, int[][] dp){
    //     if(amount==0){
    //         return 0;
    //     }
    //     if(i==0){
    //         if(amount % coins[i] == 0){
    //             return amount/coins[i];
    //         }else{
    //             return MAX;
    //         }
    //     }
    //     if(dp[i][amount]!=-1){
    //         return dp[i][amount];
    //     }

    //     int notPickLength = 0 + recur(i-1, amount, coins, dp);
    //     int pickLength = MAX;
    //     if(amount >= coins[i]){
    //         pickLength = 1 + recur(i, amount-coins[i], coins, dp);
    //     }
    //     return dp[i][amount] = Math.min(pickLength, notPickLength);
    // }

    int MAX = 1000000009;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i<n; i++){
            dp[i][0] = 0;
        }

        for(int a = 0; a<=amount; a++){
            if(a % coins[0] == 0){
                dp[0][a] =  a/coins[0];
            }else{
                dp[0][a] = MAX;
            }
        }

        for(int i = 1; i<n; i++){
            for(int a = 1; a<=amount; a++){
                int notPickLength = 0 + dp[i-1][a];
                int pickLength = MAX;
                if(a >= coins[i]){
                    pickLength = 1 + dp[i][a-coins[i]] ;
                }
                dp[i][a] = Math.min(pickLength, notPickLength);
            }
        }

        if(dp[n-1][amount] >= MAX){
            return -1;
        }
        return dp[n-1][amount];
    }

}