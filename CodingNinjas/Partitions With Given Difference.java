import java.util.* ;
import java.io.*; 
public class Solution {
	static int MOD = 1000000007;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int sum = 0;
		for(int x: arr){
			sum+=x;
		}
		if((sum+d) %2==1){
			return 0;
		}
		int newTarget = (sum+d) /2;
		return findWays(arr, newTarget);
	}
	public static int findWays(int num[], int tar) {
        // Write your code here.

        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(n-1, tar, num, dp);
    }
    static int recur(int i, int t, int[] num, int[][] dp){
        if(i==0){
            if(t==0 && num[i]==0){
                return 2;
            }
            if(num[i]==t){
                return 1;
            }
            if(t==0){
                return 1;
            }
            return 0;
        }
        if(t<0){
            return 0;
        }
        if(dp[i][t]!=-1){
            return dp[i][t];
        }
        int pick = recur(i-1, t-num[i], num, dp);
        int notPick = recur(i-1, t, num, dp);
        return dp[i][t]=(pick+notPick) % MOD;
    }
}