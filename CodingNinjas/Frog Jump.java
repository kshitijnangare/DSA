import java.util.* ;
import java.io.*; 
public class Solution {
    
    // Memoization
    
    public static int frogJump(int n, int heights[]) {
        // Write your code here..
        
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
        return memoization(n-1, heights, dp);
    }
    
    static int memoization(int n, int[] heights, int[] dp){
        if(n<=0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left = memoization(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right = memoization(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        }
        return dp[n] = Math.min(left,right);
    }
    
    // Tabulation
    
    // public static int frogJump(int n, int heights[]) {
    //     if(n==1){
    //         return 0;
    //     }
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0]=0;
    //     dp[1] = Math.abs(heights[1]-heights[0]);
    //     for(int i = 2; i<n; i++){
    //         int diff1=Math.abs(heights[i]-heights[i-1]) + dp[i-1];
    //         int diff2=Math.abs(heights[i]-heights[i-2]) + dp[i-2];
    //         dp[i] = Math.min(diff1,diff2);
    //     }
    //     return dp[n-1];
    // }
    
    // Space Optimization
    
    // public static int frogJump(int n, int heights[]) {
    //     if(n==1){
    //         return 0;
    //     }
    //     int prev2=0;
    //     int prev1 = Math.abs(heights[1]-heights[0]);
    //     int curr = prev1;
    //     for(int i = 2; i<n; i++){
    //         int diff1=Math.abs(heights[i]-heights[i-1]) + prev1;
    //         int diff2=Math.abs(heights[i]-heights[i-2]) + prev2;
    //         curr = Math.min(diff1,diff2);
    //         prev2=prev1;
    //         prev1=curr;
    //     }
    //     return curr;
    // }

}