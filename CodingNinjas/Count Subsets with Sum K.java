import java.util.*;
import java.io.*;

public class Solution {
    // static int MOD = 1000000007;
    // public static int findWays(int num[], int tar) {
    //     // Write your code here.

    //     int n = num.length;
    //     int[][] dp = new int[n][tar+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n-1, tar, num, dp);
    // }
    // static int recur(int i, int t, int[] num, int[][] dp){
    //     if(i==0){
    //         if(t==0 && num[i]==0){
    //             return 2;
    //         }
    //         if(num[i]==t){
    //             return 1;
    //         }
    //         if(t==0){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(t<0){
    //         return 0;
    //     }
    //     if(dp[i][t]!=-1){
    //         return dp[i][t];
    //     }
    //     int pick = recur(i-1, t-num[i], num, dp);
    //     int notPick = recur(i-1, t, num, dp);
    //     return dp[i][t]=(pick+notPick) % MOD;
    // }


    // tabultaion
    static int MOD = 1000000007;
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        dp[0][0]= num[0]==0 ? 2 : 1;
        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int t = 0; t<=tar; t++){
                int notPick = dp[i-1][t];
                int pick = 0;
                if(t-num[i]>=0){
                    pick = dp[i-1][t-num[i] ];
                }
                dp[i][t]=(pick+notPick)%MOD;
            }
        }
        return dp[n-1][tar];
    }
}