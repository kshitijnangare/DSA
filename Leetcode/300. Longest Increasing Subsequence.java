class Solution {
    // recursion
    // public int lengthOfLIS(int[] nums) {
    //     return recur(0, -1,nums);
    // }
    // int recur(int i, int prevInd, int[] nums){
    //     if(i==nums.length){
    //         return 0;
    //     }

    //     // I decide to take the element but I need to check it with prevInd taken.
    //     // instead of storing the value of prev element store its index
    //     // so that when we create the DP array it will be easyy for us to define the size
    //     int prev = prevInd == -1 ? Integer.MIN_VALUE : nums[prevInd];
    //     int curr = nums[i];
    //     if(prev<curr){
    //         // yes prevInd value is smaller than curr ind value, hence move ahead by taking it
    //         // and put currInd as prevInd
    //         int take = 1 + recur(i+1, i, nums);
    //         // but still I can not take even its eligible (i have that option)
    //         int nottake = 0 + recur(i+1, prevInd, nums);
    //         // we need to return the max
    //         return Math.max(take, nottake);
    //     }else{
    //         // no its not smaller hence we need to skip current element
    //         int nottake = 0 + recur(i+1, prevInd, nums);
    //         return nottake;
    //     }
    // }

    // memoization
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     // prevInd goes from -1 to n-1
    //     // currInd goes from 0 to n;
    //     int[][] dp = new int[n+1][n+1];
    //     for(int[] row: dp){Arrays.fill(row,-1);}
    //     return recur(0, -1,nums, dp);
    // }
    // int recur(int i, int prevInd, int[] nums, int[][] dp){
    //     if(i==nums.length){
    //         return 0;
    //     }
    //     if(dp[i][prevInd+1]!=-1){
    //         return dp[i][prevInd+1];
    //     }

    //     // I decide to take the element but I need to check it with prevInd taken.
    //     // instead of storing the value of prev element store its index
    //     // so that when we create the DP array it will be easyy for us to define the size
    //     int prev = prevInd == -1 ? Integer.MIN_VALUE : nums[prevInd];
    //     int curr = nums[i];
    //     if(prev<curr){
    //         // yes prevInd value is smaller than curr ind value, hence move ahead by taking it
    //         // and put currInd as prevInd
    //         int take = 1 + recur(i+1, i, nums, dp);
    //         // but still I can not take even its eligible (i have that option)
    //         int nottake = 0 + recur(i+1, prevInd, nums, dp);
    //         // we need to return the max
    //         return dp[i][prevInd+1]=Math.max(take, nottake);
    //     }else{
    //         // no its not smaller hence we need to skip current element
    //         int nottake = 0 + recur(i+1, prevInd, nums, dp);
    //         return dp[i][ +1]=nottake;
    //     }
    // }

    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     // prevInd goes from -1 to n-1
    //     // currInd goes from 0 to n;
    //     int[][] dp = new int[n+1][n+1];
    //     int offset = 1;
    //     for(int j= -1; j<n; j++){
    //         dp[n][j+offset]=0;
    //     }

    //     for(int i = n-1; i>=0; i--){
    //         for(int j = -1; j<i; j++){
    //             int prev = j == -1 ? Integer.MIN_VALUE : nums[j];
    //             int curr = nums[i];
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

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
        }
        int maxLen = 0;
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[prev]<nums[i]){
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