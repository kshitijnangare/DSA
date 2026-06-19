import java.util.* ;
import java.io.*; 
public class Solution {

    // This solution can become a solution of Subset Sum Equals K Problem
    // Explaination:
    // Think of dividing the array into two groups which correctly gives target: 
    // S1: The numbers assigned + sign.
    // S2: The numbers assigned - sign.
    // Now think again and we get the following:
    // S1 - S2 = target (positive part - negative part)
    // S1 + S2 = totalSum of the array
    
    // add the equations we get
    // 2 x S1 = target + totalSum
    // S1 = (target + totalSum) / 2

    // The problem shifts completely: Find how many subsets sum up to exactly S1.
    // Since S1 is strictly positive, we can use the existing soluiton only.

    // memoization

    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for(int x : arr){
            totalSum += x;
        }
        
        // Edge Cases Check: target cannot be larger than total possible sum,
        // and (target + totalSum) must be an even number to divide by 2 perfectly.
        if(Math.abs(target) > totalSum || (target + totalSum) % 2 != 0){
            return 0;
        }
        
        int s1 = (target + totalSum) / 2;
        
        // dp[i][j] will store the number of ways to make sum 'j' using elements up to index 'i'
        int[][] dp = new int[n][s1 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return recur(n - 1, s1, arr, dp);
    }
    
    static int recur(int i, int sum, int[] arr, int[][] dp){
        // Base Case 1: When we reach the first element
        if(i == 0){
            // Special case for zero: if arr[0] is 0 and our remaining target sum is 0,
            // we can either pick it (+0/-0) or not pick it. Both give sum 0, so 2 ways.
            if(arr[0] == 0 && sum == 0){
                return 2;
            }
            // If the element matches the remaining sum, or if sum is 0 (by picking nothing)
            if(sum == 0 || arr[0] == sum){
                return 1;
            }
            return 0;
        }
        
        // Check if the state has already been calculated
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        // Choice 1: Do not pick the current element
        int notPick = recur(i - 1, sum, arr, dp);
        
        // Choice 2: Pick the current element (only if it fits within the remaining sum)
        int pick = 0;
        if(arr[i] <= sum){
            pick = recur(i - 1, sum - arr[i], arr, dp);
        }
        
        // Cache the combined results into our DP matrix
        return dp[i][sum] = pick + notPick;
    }
}