class Solution {
    
    // Memoization
    
    // int minCost(int[] height) {
    //     // code here
    //     int n = height.length;
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     dp[0]=0;
    //     return memoization(n-1, height, dp);
    // }
    // int memoization(int n, int[] height, int[] dp){
    //     if(n<=0){
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int left = memoization(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
    //     int right = Integer.MAX_VALUE;
    //     if(n>1){
    //         right = memoization(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
    //     }
    //     return dp[n] = Math.min(left,right);
    // }
    
    // Tabulation
    
    // int minCost(int[] height) {
    //     // code here
    //     int n = height.length;
    //     if(n==1){
    //         return 0;
    //     }
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0]=0;
    //     dp[1] = Math.abs(height[1]-height[0]);
    //     for(int i = 2; i<n; i++){
    //         int diff1=Math.abs(height[i]-height[i-1]) + dp[i-1];
    //         int diff2=Math.abs(height[i]-height[i-2]) + dp[i-2];
    //         dp[i] = Math.min(diff1,diff2);
    //     }
    //     return dp[n-1];
    // }
    
    // Space Optimization
    
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n==1){
            return 0;
        }
        int prev2=0;
        int prev1 = Math.abs(height[1]-height[0]);
        int curr = prev1;
        for(int i = 2; i<n; i++){
            int diff1=Math.abs(height[i]-height[i-1]) + prev1;
            int diff2=Math.abs(height[i]-height[i-2]) + prev2;
            curr = Math.min(diff1,diff2);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
        
    }
}