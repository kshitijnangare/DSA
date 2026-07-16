import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        int n = arr.length;
        if(n<=2){
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int z = 0; z<n; z++){
            dp[z][z]=0;
        }
        
        for(int i = n-1; i>=1; i--){
            for(int j = i+1; j<n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k<j; k++){
                    int ops =  arr[i-1]*arr[k]*arr[j];
                    int firstPartition = dp[i][k];
                    int secondPartition=dp[k+1][j];
                    int totalOps = ops + firstPartition + secondPartition;
                    min = Math.min(min, totalOps);
                }
                dp[i][j]=min;
            }
        }
        
        return dp[1][n-1];
	}
}
