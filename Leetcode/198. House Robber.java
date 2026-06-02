class Solution {
    // memoization

    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if(n==1){
    //         return nums[0];
    //     }
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     dp[0] = nums[0];
    //     return memo(n-1, nums, dp);
    // }

    // int memo(int i, int[] nums, int[] dp){
    //     if(i<0){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }

    //     int pick = nums[i] + memo(i-2, nums, dp);
    //     int notPick = 0 + memo(i-1, nums, dp);
    //     return dp[i] = Math.max(pick, notPick);  
    // }

    // Tabulation
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if(n==1){
    //         return nums[0];
    //     }
    //     int[] dp = new int[n];
    //     dp[0]=nums[0];
    //     dp[1]=Math.max(nums[0], nums[1]);
    //     for(int i = 2; i<n; i++){
    //         int pick = dp[i-2] + nums[i];
    //         int notPick = dp[i-1] + 0;
    //         dp[i] = Math.max(pick, notPick);
    //     }
    //     return dp[n-1];
    // }

    // space optimization
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2=nums[0];
        int prev1=Math.max(nums[0], nums[1]);
        int curr = prev1;
        for(int i = 2; i<n; i++){
            int pick = prev2 + nums[i];
            int notPick = prev1 + 0;
            curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}