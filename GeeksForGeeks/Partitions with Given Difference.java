class Solution {
    int MOD = 1000000007;
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum = 0;
        for(int x:arr){
            sum+=x;
        }
        if((sum+diff) %2==1){
            return 0;
        }
        int newTarget = (sum+diff)/2;
        return perfectSum(arr, newTarget);
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(n-1, target, nums, dp);
        
    }
    
    int recur(int i, int t, int[] num, int[][] dp){
        if(i==0){
            if(t==0 && num[i]==0){
                return 2;
            }
            if(num[i]==t){
                return 1;
            }
            if(t==0){
                return 1;
            }
            return 0;
        }
        if(t<0){
            return 0;
        }
        if(dp[i][t]!=-1){
            return dp[i][t];
        }
        int pick = recur(i-1, t-num[i], num, dp);
        int notPick = recur(i-1, t, num, dp);
        return dp[i][t]=(pick+notPick) % MOD;
    }

}
