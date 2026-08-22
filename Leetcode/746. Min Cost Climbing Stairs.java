class Solution {
    // recursion
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int start1 = recur(n-1, cost);
    //     int start2 = recur(n-2, cost);
    //     return Math.min(start1, start2);
    // }
    // int recur(int i, int[] cost){
    //     if(i==1 || i==0){
    //         return cost[i];
    //     }

    //     int step1 = cost[i]+recur(i-1, cost);
    //     int step2 = cost[i]+recur(i-2, cost);
    //     return Math.min(step1, step2);
    // }

    // memo
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     int start1 = recur(n-1, cost, dp);
    //     int start2 = recur(n-2, cost, dp);
    //     return Math.min(start1, start2);
    // }
    // int recur(int i, int[] cost, int[] dp){
    //     if(i==1 || i==0){
    //         return cost[i];
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }

    //     int step1 = cost[i]+recur(i-1, cost, dp);
    //     int step2 = cost[i]+recur(i-2, cost, dp);
    //     return dp[i]=Math.min(step1, step2);
    // }

    // tabulation

    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n];

    //     dp[0]=cost[0];
    //     dp[1]=cost[1];

    //     for(int i = 2; i<n; i++){
    //         int step1 = cost[i]+dp[i-1];
    //         int step2 = cost[i]+dp[i-2];
    //         dp[i]=Math.min(step1, step2);
    //     }
    //     return Math.min(dp[n-2], dp[n-1]);
    // }

    // space optimization
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int second=cost[0];
        int first=cost[1];

        for(int i = 2; i<n; i++){
            int step1 = cost[i]+first;
            int step2 = cost[i]+second;
            int curr =Math.min(step1, step2);
            second = first;
            first = curr;
        }
        return Math.min(first, second);
    }
}