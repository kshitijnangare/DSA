class Solution {
    
    // recursion
    // public int knapSack(int val[], int wt[], int capacity) {
    //     // code here
    //     int n = val.length;
    //     return recur(n-1, capacity, val, wt);
    // }
    // int recur(int i, int bagwt, int[] val, int[] wt){
    //     if(i==0){
    //          return (bagwt/wt[i]) * val[i];
    //     }
    //     if(bagwt==0){
    //         return 0;
    //     }
    //     int notPick = 0 + recur(i-1, bagwt, val, wt);
    //     int pick = 0;
    //     if(bagwt>=wt[i]){
    //         pick = val[i] + recur(i, bagwt-wt[i], val, wt);
    //     }
    //     return Math.max(notPick, pick);
    // }
    
    
    // // memoization
    // public int knapSack(int val[], int wt[], int capacity) {
    //     // code here
    //     int n = val.length;
    //     int[][] dp = new int[n][capacity+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, capacity, val, wt, dp);
    // }
    // int recur(int i, int bagwt, int[] val, int[] wt, int[][] dp){
    //     if(i==0){
    //         return (bagwt/wt[i]) * val[i];
    //     }
    //     if(bagwt==0){
    //         return 0;
    //     }
    //     if(dp[i][bagwt]!=-1){
    //         return dp[i][bagwt];
    //     }
        
    //     int notPick = 0 + recur(i-1, bagwt, val, wt, dp);
    //     int pick = 0;
    //     if(bagwt>=wt[i]){
    //         pick = val[i] + recur(i, bagwt-wt[i], val, wt, dp);
    //     }
    //     return dp[i][bagwt] = Math.max(notPick, pick);
    // }
    
    
    // Tabultation
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        // if(i==0){
        //     return (bagwt/wt[i]) * val[i];
        // }
        
        for(int bagwt=0; bagwt<=capacity; bagwt++){
            dp[0][bagwt]= (bagwt/wt[0]) * val[0];
        }
        
        // if(bagwt==0){
        //     return 0;
        // }
        for(int i = 0; i<n; i++){
            dp[i][0]=0;
        }
        
        
        for(int i = 1; i<n; i++){
            for(int bagwt = 1; bagwt<=capacity; bagwt++){
                int notPick = 0 + dp[i-1][bagwt];
                int pick = 0;
                if(bagwt>=wt[i]){
                    pick = val[i] + dp[i][bagwt-wt[i]];
                }
                dp[i][bagwt] = Math.max(notPick, pick);
            }
        }
        return dp[n-1][capacity];
    }
}