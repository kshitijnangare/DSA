import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return memo(0,0,triangle,n,dp);

    }
    public static int memo(int i, int j, int[][] t, int n, int[][] dp){
        if(i==n-1){
            return t[n-1][j];
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int down = memo(i+1, j, t, n, dp);
        int diagonal = memo(i+1, j+1, t, n, dp);
        return dp[i][j] = t[i][j] + Math.min(down, diagonal);
    }
}