// User function Template for Java

class Solution {
    
    // memoization
    // int findMaxSum(int arr[], int n) {
    //     // code here
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     dp[0]=arr[0];
    //     return memo(n-1, arr, dp);
        
    // }
    // int memo(int n, int[] arr, int[] dp){
    //     if(n==0){
    //         return arr[0];
    //     }
    //     if(n<1){
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int pick = arr[n]+ memo(n-2, arr, dp);
    //     int notPick = 0 + memo(n-1, arr, dp);
        
        
    //     return dp[n] = Math.max(pick, notPick);
    // }
    
    // Tabulation
    // int findMaxSum(int arr[], int n){
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     dp[0]=arr[0];
    //     if(n==1){
    //         return arr[0];
    //     }
    //     dp[1]=Math.max(arr[0], arr[1]);
    //     for(int i = 2; i<n; i++){
    //         int pick = arr[i] + dp[i-2];
    //         int notPick = 0 + dp[i-1];
    //         dp[i] = Math.max(pick, notPick);
    //     }
    //     return dp[n-1];
    // }
    
    // Space optimization
    int findMaxSum(int arr[], int n){
        int prev2=arr[0];
        if(n==1){
            return arr[0];
        }
        int prev1=Math.max(arr[0], arr[1]);
        int curr = prev1;
        for(int i = 2; i<n; i++){
            int pick = arr[i] + prev2;
            int notPick = 0 + prev1;
            curr = Math.max(pick, notPick);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
    
}