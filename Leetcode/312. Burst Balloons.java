class Solution {
    // recursion
    // public int maxCoins(int[] nums) {
    //     int n = nums.length;
    //     int[] copy = new int[n+2];
    //     copy[0]=1;
    //     copy[n+1]=1;
    //     for(int i = 0; i<n; i++){
    //         copy[i+1]=nums[i];
    //     }
    //     n=n+2;
    //     return recur(1, n-2, copy);
    // }
    // int recur(int i , int j, int[] copy){
    //     if(i>j){
    //         return 0;
    //     }

    //     int max = Integer.MIN_VALUE;
    //     for(int k = i; k<=j; k++){
    //         int cost = copy[i-1]*copy[k]*copy[j+1];
    //         int firstPartition = recur(i, k-1, copy);
    //         int secondPartition = recur(k+1, j, copy);
    //         int totalCoins = cost+firstPartition+secondPartition;
    //         max = Math.max(max, totalCoins);
    //     }
    //     return max;
    // }

    // memoization
    // public int maxCoins(int[] nums) {
    //     int n = nums.length;
    //     int[] copy = new int[n+2];
    //     copy[0]=1;
    //     copy[n+1]=1;
    //     for(int i = 0; i<n; i++){
    //         copy[i+1]=nums[i];
    //     }
    //     n=n+2;
    //     int dp[][] = new int[n][n];
    //     for(int[] rows: dp){
    //         Arrays.fill(rows,-1);
    //     }
    //     return recur(1, n-2, copy, dp);
    // }
    // int recur(int i , int j, int[] copy, int[][] dp){
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int max = Integer.MIN_VALUE;
    //     for(int k = i; k<=j; k++){
    //         int cost = copy[i-1]*copy[k]*copy[j+1];
    //         int firstPartition = recur(i, k-1, copy, dp);
    //         int secondPartition = recur(k+1, j, copy, dp);
    //         int totalCoins = cost+firstPartition+secondPartition;
    //         max = Math.max(max, totalCoins);
    //     }
    //     return dp[i][j]=max;
    // }

    // tabulation
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n+2];
        copy[0]=1;
        copy[n+1]=1;
        for(int i = 0; i<n; i++){
            copy[i+1]=nums[i];
        }
        n=n+2;
        int dp[][] = new int[n][n];
        for(int j = 0; j<n; j++){
            for(int i = n-1; i>j ; i--){
                dp[i][j]=0;
            }
        }

        for(int i = n-2; i>=1; i--){
            for(int j = i; j<n-1; j++){
                int max = Integer.MIN_VALUE;
                for(int k = i; k<=j; k++){
                    int cost = copy[i-1]*copy[k]*copy[j+1];
                    int firstPartition = dp[i][k-1];
                    int secondPartition = dp[k+1][j];
                    int totalCoins = cost+firstPartition+secondPartition;
                    max = Math.max(max, totalCoins);
                }
                dp[i][j]=max;
            }
        }
                
        return dp[1][n-2];
    }
}