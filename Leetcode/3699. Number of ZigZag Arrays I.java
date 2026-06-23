import java.util.Arrays;

class Solution {
    // memoization will give TLE we need tabulation appraoch only but first I will do memoization and then convert to tabulation for better understanding of the PS
    // strivers method
    // express in terms of index
    // so we need f(index, prevValue, direction)
    // then do all stuff on that index
    // then the base cases and then count the maximum

    // int[][][] dp;
    // int MOD=1000000007;
    // int L,R;
    // public int zigZagArrays(int n, int l, int r) {
    //     L=l;
    //     R=r;
    //     int range=r-l+1;
    //     if(n==1)return range;
    //     dp=new int[n+1][range+1][2];
    //     for(int[][] d2:dp){
    //         for(int[] d1:d2){
    //             Arrays.fill(d1,-1);
    //         }
    //     }
    //     long total=0;
    //     for(int v1=l;v1<=r;v1++){
    //         for(int v2=l;v2<=r;v2++){
    //             if(v1!=v2){
    //                 boolean nextUp=v2<v1;
    //                 total=(total+recur(2,v2,nextUp?1:0))%MOD;
    //             }
    //         }
    //     }
    //     return (int)total;
    // }
    // int recur(int idx,int lastVal,int isUp) {
    //     if(idx==dp.length-1)return 1;
    //     if(dp[idx][lastVal-L][isUp]!=-1)return dp[idx][lastVal-L][isUp];
    //     long ans=0;
    //     if(isUp==1){
    //         for(int nextV=lastVal+1;nextV<=R;nextV++){
    //             ans=(ans+recur(idx+1,nextV,0))%MOD;
    //         }
    //     }else{
    //         for(int nextV=L;nextV<lastVal;nextV++){
    //             ans=(ans+recur(idx+1,nextV,1))%MOD;
    //         }
    //     }
    //     return dp[idx][lastVal-L][isUp]=(int)ans;
    // }

    // tabulation
    public int zigZagArrays(int n, int l, int r) {
        int range=r-l+1;
        if(n==1)return range;
        int MOD=1000000007;
        int[][][] dp=new int[n+1][range][2];
        for(int x=0;x<range;x++){
            dp[1][x][0]=1;
            dp[1][x][1]=1;
        }
        for(int i=2;i<=n;i++){
            long prefixSum=0;
            for(int x=0;x<range;x++){
                dp[i][x][0]=(int)(prefixSum%MOD);
                prefixSum+=dp[i-1][x][1];
            }
            long suffixSum=0;
            for(int x=range-1;x>=0;x--){
                dp[i][x][1]=(int)(suffixSum%MOD);
                suffixSum+=dp[i-1][x][0];
            }
        }
        long total=0;
        for(int x=0;x<range;x++){
            total=(total+dp[n][x][0]+dp[n][x][1])%MOD;
        }
        return (int)total;
    }
}