class Solution {

    // recursion
    // 1. express in terms of index
    // public int minCost(int n, int[] cuts) {
    //     // we need to sort the cuts array so that we can solve the two sticks that form
    //     // due to cut independently
    //     int len = cuts.length;
    //     int[] copy = Arrays.copyOf(cuts, len+2);
    //     len = copy.length;
    //     copy[len-1]=0;
    //     copy[len-2]=n;
    //     Arrays.sort(copy);
    //     return recur(1, len-2, copy);

    // }
    // int recur(int i , int j, int[] copy){
    //     // no need to cut as its
    //     if(i>j){
    //         return 0;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(int k = i; k<=j; k++){
    //         int cost = copy[j+1] - copy[i-1];
    //         int firstPartition = recur(i, k-1, copy);
    //         int secondPartition = recur(k+1, j, copy);
    //         int totalCost = cost + firstPartition + secondPartition;
    //         min = Math.min(min, totalCost);
    //     }
    //     return min;
    // }

    // memoization
    // public int minCost(int n, int[] cuts) {
    //     // we need to sort the cuts array so that we can solve the two sticks that form
    //     // due to cut independently
    //     int len = cuts.length;
    //     int[] copy = Arrays.copyOf(cuts, len+2);
    //     len = copy.length;
    //     copy[len-1]=0;
    //     copy[len-2]=n;
    //     Arrays.sort(copy);
    //     int[][] dp = new int[len][len];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(1, len-2, copy, dp);

    // }
    // int recur(int i , int j, int[] copy, int[][] dp){
    //     // no need to cut as its
    //     if(i>j){
    //         return 0;
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int min = Integer.MAX_VALUE;
    //     for(int k = i; k<=j; k++){
    //         int cost = copy[j+1] - copy[i-1];
    //         int firstPartition = recur(i, k-1, copy, dp);
    //         int secondPartition = recur(k+1, j, copy, dp);
    //         int totalCost = cost + firstPartition + secondPartition;
    //         min = Math.min(min, totalCost);
    //     }
    //     return dp[i][j]=min;
    // }

    // tabulation
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] copy = Arrays.copyOf(cuts, len+2);
        len = copy.length;
        copy[len-1]=0;
        copy[len-2]=n;
        Arrays.sort(copy);
        int[][] dp = new int[len][len];
        
        for(int j = 0; j<len; j++){
            for(int i = len-1; i>j; i--){
                dp[i][j]=0;
            }
        }

        // int recursion i went from 1 to len-2
        // here it will b reverse
        for(int i = len-2; i>=1; i--){
            // j went from len-2 to i. here goes reverese
            for(int j = i; j<=len-2; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k<=j; k++){
                    int cost = copy[j+1] - copy[i-1];
                    int firstPartition = dp[i][k-1];
                    int secondPartition = dp[k+1][j];
                    int totalCost = cost + firstPartition + secondPartition;
                    min = Math.min(min, totalCost);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][len-2];
    }
}