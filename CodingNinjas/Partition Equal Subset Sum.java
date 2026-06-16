import java.util.*;
import java.io.*; 
public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		// code here
		int sum = 0;
		for(int x: arr){
			sum+=x;
		}
		if(sum %2==1){
			return false;
		}
		int k = sum/2;
        int i = arr.length-1;
        int[][] dp = new int[arr.length][k+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(i, k, arr, dp);
    }
    static Boolean recur(int i, int sum, int[] arr, int[][] dp){
        if(sum<0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(i==0){
            return arr[i]==sum;
        }
        if(dp[i][sum] != -1){
            if(dp[i][sum]==1) return true;
            else return false;
        }
        
        boolean pick = recur(i-1, sum-arr[i], arr, dp);
        boolean notPick = recur(i-1, sum, arr, dp);
        if(pick || notPick){
            dp[i][sum]=1;
        }else{
            dp[i][sum]=0;
        }
        return pick || notPick;
    }
}