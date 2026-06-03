class Solution {
    
    //Basic Recursion

    // public int numberOfPaths(int m, int n) {
    //     return recursion(m-1,n-1);
    // }
    // int recursion(int i, int j){
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     int up = recursion(i, j-1);
    //     int left = recursion(i-1, j);
    //     return up+left;
    // }

    // Memoization --> converted from recursion
    public int numberOfPaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recursion(m-1,n-1, dp);
    }
    int recursion(int i, int j, int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = recursion(i, j-1, dp);
        int left = recursion(i-1, j, dp);
        return dp[i][j]=up+left;
    }

    // Tabulation
    // public int numberOfPaths(int m, int n) {
    //     if(m==1 || n==1){
    //         return 1;
    //     }
    //     // step 1: declare the array of DP
    //     int[][] dp = new int[m][n];

    //     // step 2: express all states in the form of loops
    //     for(int i = 0; i<m; i++){
    //         for(int j = 0; j<n; j++){
    //             if(i==0 && j==0){ // part of step 1: delare and express base case in form of dp array
    //                 dp[i][j]=1;
    //             }else{
    //                 // VVIMP*** step 3: copy the recurrence as it is. replace function name with dp and keep the indexes as it is.
    //                 int up = j>0 ? dp[i][j-1] : 0;
    //                 int left = i>0 ? dp[i-1][j] : 0;
    //                 dp[i][j] = up+left;
    //             }
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }

    // Space optimization
    // public int numberOfPaths(int m, int n) {
    //     if(m==1 || n==1){
    //         return 1;
    //     }
    //     int[] prev = new int[n];
    //     Arrays.fill(prev, 0);
    //     int[] curr = prev;

    //     for(int i = 0; i<m; i++){
    //         for(int j = 0; j<n; j++){
    //             if(i==0 && j==0){ 
    //                 curr[j]=1;
    //             }else{
    //                 int up = j>0 ? curr[j-1] : 0;
    //                 int left = prev[j];
    //                 curr[j] = up+left;
    //                 prev=curr;
    //             }
    //         }
    //     }
    //     return curr[n-1];
    // }

    // using maths formula. simple geeksforgeeks technique
    // public int numberOfPaths(int m, int n) {
    //     long path=1;
    //     int total=m+n-2;        
    //     int r=Math.min(m-1,n-1);

    //     for(int i=1;i<=r; i++) {
    //         path=path*(total-r+i)/i;
    //     }
    //     return (int)path;
    // }
}