class Solution {
    public static int maxSkill(int[] arr) {
        // code here
        int n = arr.length;
        int[] copy = new int[n+2];
        copy[0]=1;
        copy[n+1]=1;
        for(int i = 0; i<n; i++){
            copy[i+1]=arr[i];
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
