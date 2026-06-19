class Solution {
    public int minDifference(int arr[]) {
        // code here
        int n = arr.length;
        int totalsum = 0;
        for(int x: arr){
            totalsum+=x;
        }
        boolean[][] dp = new boolean[n][totalsum+1];
        for(int i = 0; i<n; i++){
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        int target = totalsum;
        for(int i = 1; i<n; i++){
            for(int t = 1; t<=target; t++){
                boolean pick = false;
                if(t-arr[i]>=0){
                    pick = dp[i-1][t-arr[i]];
                }
                boolean notPick = dp[i-1][t];
                dp[i][t] = pick || notPick;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int t = 0; t<=totalsum; t++){
            if(dp[n-1][t] == true){
                int diff = Math.abs( t - (totalsum-t) );
                ans = Math.min(ans, diff );
            }
        }
        return ans;
    }
}
