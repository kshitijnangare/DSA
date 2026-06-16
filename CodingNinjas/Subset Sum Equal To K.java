import java.util.* ;
import java.io.*; 
public class Solution {
    // public static Boolean subsetSumToK(int n, int k, int arr[]) {
    //     // code here
    //     int i = arr.length-1;
    //     int[][] dp = new int[arr.length][k+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(i, k, arr, dp);
    // }
    // static Boolean recur(int i, int sum, int[] arr, int[][] dp){
    //     if(sum<0){
    //         return false;
    //     }
    //     if(sum==0){
    //         return true;
    //     }
    //     if(i==0){
    //         return arr[i]==sum;
    //     }
    //     if(dp[i][sum] != -1){
    //         if(dp[i][sum]==1) return true;
    //         else return false;
    //     }
        
    //     boolean pick = recur(i-1, sum-arr[i], arr, dp);
    //     boolean notPick = recur(i-1, sum, arr, dp);
    //     if(pick || notPick){
    //         dp[i][sum]=1;
    //     }else{
    //         dp[i][sum]=0;
    //     }
    //     return pick || notPick;
    // }
    
    
    
    public static Boolean subsetSumToK(int n, int k, int arr[]) {
        int sum = k;
        boolean[][] dp = new boolean[n][sum+1];
        
        // base case 1 (sum==0) i can be anything
        for(int i = 0; i<n; i++){
            dp[i][0]=true;
        }
        // base case 2 (i==0) return arr[i]==sum
        // so when i becomes zero then if arr[i]==sum its true.
        
        if(arr[0]<=sum){// just a check if arr[0]=7 and sum is 5 then dp[0][7] is out of bound
            dp[0][arr[0]] = true;
        }
        
        // two states two loops in reverse order (main is i)
        for(int i = 1; i<n; i++){
            for(int loopsum = sum; loopsum>=1; loopsum--){
                // copy recurrence and change in dp array and keep a check
                // only if sum-arr[i]>=0 then it takes dp value else its false
                boolean pick = false; // case when sum<0 we return false
                if(loopsum-arr[i]>=0){
                    pick = dp[i-1][loopsum-arr[i]];
                }
                boolean notPick = dp[i-1][loopsum];
                dp[i][loopsum] = pick||notPick;
            }
        }
        
        return dp[n-1][sum];
    }
}
