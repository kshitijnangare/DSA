import java.util.*;
public class Solution {
    public static int countSquares(int n, int m, int[][] arr) {
        // Write your code here.
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        for(int r[]: dp){
            Arrays.fill(r, 0);
        }
        int sum = 0;
        for(int i =  0; i<row; i++){
            dp[i][0] = arr[i][0];
            sum += dp[i][0];
        }
        for(int j = 1; j<col; j++){
            dp[0][j]=arr[0][j];
            sum+=dp[0][j];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1;j<col; j++){
                if(arr[i][j]==1){
                    int min = Integer.MAX_VALUE;
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diag = dp[i-1][j-1];
                    min = Math.min(up, Math.min(left, diag));
                    dp[i][j]=min+1;
                }else{
                    dp[i][j]=0;
                }
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}