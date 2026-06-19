class Solution {

    // recursion
    // public int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     return recur(n-1, amount, coins);
    // }
    // int recur(int i, int amount, int[] coins){
    //     if(amount==0){
    //         return 1; // one will get added to the count
    //     }
    //     if(i==0){
    //         if(amount % coins[i] == 0){
    //             return 1; // one will get added to totalcount;
    //         }else{
    //             return 0; // not possible hence 0 will get added;
    //         }
    //     }
    //     int notPick = recur(i-1, amount, coins); // simply call recursion
    //     int pick = 0; // suppose it does not yeild results
    //     if(amount >= coins[i]){
    //         pick = recur(i, amount-coins[i], coins); // it may results but infinite supply rule hence index same
    //     }
    //     return pick+notPick; // return the total of all the counts
    // }

    // memoization
    // public int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, amount, coins, dp);
    // }
    // int recur(int i, int amount, int[] coins, int[][] dp){
    //     if(amount==0){
    //         return 1; // one will get added to the count
    //     }
    //     if(i==0){
    //         if(amount % coins[i] == 0){
    //             return 1; // one will get added to totalcount;
    //         }else{
    //             return 0; // not possible hence 0 will get added;
    //         }
    //     }

    //     if(dp[i][amount]!=-1){
    //         return dp[i][amount];
    //     }

    //     int notPick = recur(i-1, amount, coins, dp); // simply call recursion
    //     int pick = 0; // suppose it does not yeild results
    //     if(amount >= coins[i]){
    //         pick = recur(i, amount-coins[i], coins, dp); // it may results but infinite supply rule hence index same
    //     }
    //     return dp[i][amount] = pick+notPick; // return the total of all the counts
    // }

    // tabulation
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];


        // if(amount==0){
        //     return 1; // one will get added to the count
        // }

        // for the above base case the following is the representation in dp array
        
        for(int i = 0; i<n; i++){
            dp[i][0]=1;
        }

        // if(i==0){
        //     if(amount % coins[i] == 0){
        //         return 1; // one will get added to totalcount;
        //     }else{
        //         return 0; // not possible hence 0 will get added;
        //     }
        // }
        // and for the above base case the following is the dp representation

        for(int a = 0; a<=amount; a++){
            if(a % coins[0]==0){
                dp[0][a]=1;
            }else{
                dp[0][a] = 0;
            }
        }

        for(int i =1 ; i<n; i++){
            for(int a = 1; a<=amount; a++){

                int notPick = dp[i-1][a]; 
                int pick = 0; // suppose it does not yeild results
                if(a >= coins[i]){
                    pick = dp[i][a-coins[i]]; // it may results but infinite supply rule hence index same
                }
                dp[i][a] = pick+notPick; // store the total of all the counts
            }
        }
        return dp[n-1][amount];
    }
}