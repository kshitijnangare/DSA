class Solution {
    int MOD = 1000000007;
    public int countWays(int n, int m) {
        // code here
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recur(n, m, dp);
    }
    int recur(int i, int size, int[] dp){
        if(i<size){
            return 1;
        }
        if(i==size){
            return 2;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int horizontal = recur(i-1, size, dp);
        int vertical = recur(i-size, size, dp);
        return dp[i]=(horizontal + vertical) % MOD;
    }
}