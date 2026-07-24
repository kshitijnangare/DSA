class Solution {
    // memoziation
    // public int maxSumAfterPartitioning(int[] arr, int k) {
    //     int n = arr.length;
    //     int[][] maxsum = new int[n][n];
    //     for(int i = 0; i<n; i++){
    //         int max = arr[i];
    //         for(int j = i; j<n; j++){
    //             max = Math.max(max, arr[j]);
    //             maxsum[i][j] = max;
    //         }
    //     }
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return recur(0, arr, k, maxsum, dp);
    // }
    // int recur(int i, int[] arr, int k, int[][]maxsum, int[] dp){
    //     if(i==arr.length){return 0;}
    //     if(dp[i]!=-1){return dp[i];}

    //     int max = 0;
    //     for(int j = i; j<Math.min(arr.length, i+k);j++){
    //         int sum = maxsum[i][j] * (j-i+1) + recur(j+1, arr, k, maxsum, dp);
    //         max = Math.max(max, sum);
    //     }
    //     return dp[i]=max;
    // }


    //tabulation
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] maxsum = new int[n][n];
        for(int i = 0; i<n; i++){
            int max = arr[i];
            for(int j = i; j<n; j++){
                max = Math.max(max, arr[j]);
                maxsum[i][j] = max;
            }
        }
        int[] dp = new int[n+1];
        dp[n]=0;
        
        for(int i = n-1; i>=0; i--){
            int max = 0;
            for(int j = i; j<Math.min(arr.length, i+k);j++){
                int sum = maxsum[i][j] * (j-i+1) + dp[j+1];
                max = Math.max(max, sum);
            }
            dp[i]=max;
        }

        return dp[0];
    }
}