import java.util.*;
public class Solution {

    // Tabulation
    public static int maxMoneyLooted(int[] houses) {
        int n = houses.length;
        if(n==1){
            return houses[0];
        }
        int[] dp = new int[n];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0], houses[1]);
        for(int i = 2; i<n; i++){
            int pick = dp[i-2] + houses[i];
            int notPick = dp[i-1] + 0;
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }

    // space optimization
    // public static int maxMoneyLooted(int[] houses) {
    //     int n = houses.length;
    //     if(n==1){
    //         return houses[0];
    //     }
    //     int prev2=houses[0];
    //     int prev1=Math.max(houses[0], houses[1]);
    //     int curr = prev1;
    //     for(int i = 2; i<n; i++){
    //         int pick = prev2 + houses[i];
    //         int notPick = prev1 + 0;
    //         curr = Math.max(pick, notPick);
    //         prev2 = prev1;
    //         prev1 = curr;
    //     }
    //     return curr;
    // }
}