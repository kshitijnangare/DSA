class Solution {
    
    // recursion
    // 1. express in terms of index 
    // so firstly we need to count the max profit so we need to return
    // either -INF or price[i] in base case
    // so i will change when we iterate the price arr, 
    //and the length of the rod will change after every cut
    // also always keep in mind price[i] is for len = i+1;
    
    // public int cutRod(int[] price) {
    //     // code here
    //     int n = price.length;
    //     int len = n;
    //     return recur(n-1, len, price);
    // }
    // int recur(int i, int len, int[] price){
    //     // base cases (when i == 0)
    //     if(i==0){
    //         // now suppose the rod length is len then l should be divided by 
    //         // i+1 to cut the rod perfectly.
    //         // since i+1 = 1 hence any number is divided by 1
    //         // hence simply return len/i+1 x price;
    //         return (len/(i+1)) * price[i];
    //         // or len * price[i];
    //     }
        
    //     // base case when(len==0)
    //     if(len==0){
    //         //no more cutting needed hence return 0 since no more profit added
    //         return 0;
    //     }
        
    //     // in not cut curr len price will not get added and the length of the 
    //     // rod will also not reduce
    //     int notCut = 0 + recur(i-1, len, price);
    //     int cut=0; // let it be zero first
    //     if(len >= i+1){ // len should be greater than i+1 always
    //     // profit of price[i] will get added and we can again cut with the same length
    //     // infinite supply rule problem
    //         cut = price[i] + recur(i, len-(i+1), price );
    //         //len reduced by (i+1) size
    //     }
    //     return Math.max(cut, notCut);// return max
    // }
    
    
    // // memoization
    
    // public int cutRod(int[] price) {
    //     // code here
    //     int n = price.length;
    //     int len = n;
    //     // dp array of [ind][length]
    //     int[][] dp = new int[n][len+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, len, price, dp);
    // }
    // int recur(int i, int len, int[] price, int[][] dp){
    //     // base cases (when i == 0)
    //     if(i==0){
    //         // now suppose the rod length is len then l should be divided by 
    //         // i+1 to cut the rod perfectly.
    //         // since i+1 = 1 hence any number is divided by 1
    //         // hence simply return len/i+1 x price;
    //         return (len/(i+1)) * price[i];
    //         // or len * price[i];
    //     }
        
    //     // base case when(len==0)
    //     if(len==0){
    //         //no more cutting needed hence return 0 since no more profit added
    //         return 0;
    //     }
        
    //     // dp check
    //     if(dp[i][len]!=-1){
    //         return dp[i][len];
    //     }
        
    //     // in not cut curr len price will not get added and the length of the 
    //     // rod will also not reduce
    //     int notCut = 0 + recur(i-1, len, price, dp);
    //     int cut=0; // let it be zero first
    //     if(len >= i+1){ // len should be greater than i+1 always
    //     // profit of price[i] will get added and we can again cut with the same length
    //     // infinite supply rule problem
    //         cut = price[i] + recur(i, len-(i+1), price, dp);
    //         //len reduced by (i+1) size
    //     }
    //     return dp[i][len] = Math.max(cut, notCut);// return max
    // }
    
    
    
    
    // tabulation
    
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int length = n;
        // dp array of [ind][length]
        int[][] dp = new int[n][length+1];
        
        
        for(int len = 0; len<=length; len++){
            dp[0][len] = len * price[0];
        }
        
        for(int i = 0; i<n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i<n; i++){
            for(int len = 1; len<=length; len++){
                // in not cut curr len price will not get added and the length of the 
                // rod will also not reduce
                int notCut = 0 + dp[i-1][len];
                int cut=0; // let it be zero first
                if(len >= i+1){ // len should be greater than i+1 always
                // profit of price[i] will get added and we can again cut with the same length
                // infinite supply rule problem
                    cut = price[i] + dp[i][len-(i+1)];
                    //len reduced by (i+1) size
                }
                dp[i][len] = Math.max(cut, notCut);// return max
            }
        }
        return dp[n-1][length];
    }
    
}