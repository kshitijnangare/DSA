import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
		if(n==1){return nums.get(0);}
		int[] dp = new int[n];
		Arrays.fill(dp,-1);
		dp[0] = nums.get(0);
		return memo(n-1, nums, dp);
	}
	static int memo(int n, ArrayList<Integer> nums, int[] dp){
		if(n==0){
			return nums.get(n);
		}
		if(n<0){
			return 0;
		}
		if(dp[n]!=-1){
			return dp[n];
		}
		int pick = nums.get(n) + memo(n-2,nums, dp);
		int notPick = 0 + memo(n-1, nums, dp);
		return dp[n] = Math.max(pick, notPick); 
	}
}