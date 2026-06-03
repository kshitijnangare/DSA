import java.util.*;

public class Solution {

   //Basic Recursion

    // static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
    //     return recursion(m-1,n-1, mat);
    // }
    // static int recursion(int i, int j, ArrayList<ArrayList<Integer>> mat){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(mat.get(i).get(j)==-1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     int up = recursion(i, j-1, mat);
    //     int left = recursion(i-1, j, mat);
    //     return (up+left)%1000000007;
    // }

    // Memoization --> converted from recursion
    // static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
    //     int[][] dp = new int[m][n];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recursion(m-1,n-1, dp, mat);
    // }
    // static int recursion(int i, int j, int[][] dp, ArrayList<ArrayList<Integer>> mat){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(mat.get(i).get(j)==-1){
    //         return 0;
    //     }
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up = recursion(i, j-1, dp, mat);
    //     int left = recursion(i-1, j, dp, mat);
    //     return dp[i][j]=(up+left)%1000000007;
    // }

    // Tabulation
    static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        // step 1: declare the array of DP
        int[][] dp = new int[m][n];

        // step 2: express all states in the form of loops
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat.get(i).get(j)==-1){
                    dp[i][j] = 0;
                }else if(i==0 && j==0){ // part of step 1: delare and express base case in form of dp array
                    dp[i][j]=1;
                }else{
                    // VVIMP*** step 3: copy the recurrence as it is. replace function name with dp and keep the indexes as it is.
                    int up = j>0 ? dp[i][j-1] : 0;
                    int left = i>0 ? dp[i-1][j] : 0;
                    dp[i][j] = (up+left)%1000000007;
                }
            }
        }

        return dp[m-1][n-1];
    }

    // Space optimization
    // static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
    //     int[] prev = new int[n];
    //     Arrays.fill(prev, 0);

    //     for(int i = 0; i<m; i++){
    //         int[] curr = new int[n];
    //         for(int j = 0; j<n; j++){
    //             if(mat.get(i).get(j)==-1){
    //                 curr[j]=0;
    //             }else if(i==0 && j==0){ 
    //                 curr[j]=1;
    //             }else{
    //                 int up = j>0 ? curr[j-1] : 0;
    //                 int left = prev[j];
    //                 curr[j] = (up+left)%1000000007;
    //             }
    //         }
    //         prev=curr;
    //     }
    //     return prev[n-1];
    // }
}