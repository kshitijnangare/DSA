class Solution {
    // static int lis(int arr[]) {
    //     // code here
    //     int n = arr.length;
    //     // prevInd goes from -1 to n-1
    //     // currInd goes from 0 to n;
    //     int[][] dp = new int[n+1][n+1];
    //     int offset = 1;
    //     for(int j= -1; j<n; j++){
    //         dp[n][j+offset]=0;
    //     }

    //     for(int i = n-1; i>=0; i--){
    //         for(int j = -1; j<i; j++){
    //             int prev = j == -1 ? Integer.MIN_VALUE : arr[j];
    //             int curr = arr[i];
    //             if(prev<curr){
    //                 int take = 1 + dp[i+1][i+offset];
    //                 int nottake = 0 + dp[i+1][j+offset];
    //                 dp[i][j+offset]=Math.max(take, nottake);
    //             }else{
    //                 int nottake = 0 + dp[i+1][j+offset];
    //                 dp[i][j+offset]=nottake;
    //             }
    //         }
    //     }
    //     return dp[0][-1+offset];
    // }
    
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
        }
        int maxLen = 0;
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(arr[prev]<arr[i]){
                    if(dp[i] < dp[prev]+1){
                        dp[i]= dp[prev]+1;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}