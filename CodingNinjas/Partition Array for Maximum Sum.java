public class Solution {
    public static int maximumSubarray(int arr[], int k) {
        // Write your code here..
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