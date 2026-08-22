class Solution {
    // recursion
    // public int tribonacci(int n) {
    //     if(n==0){
    //         return 0;
    //     }
    //     if(n==1 || n==2){
    //         return 1;
    //     }
    //     return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    // }

    // memo
    // public int tribonacci(int n) {
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return recur(n, dp);
    // }
    // int recur(int n, int[] dp){
    //     if(n==0){
    //         return 0;
    //     }
    //     if(n==1 || n==2){
    //         return 1;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     return dp[n]=recur(n-1, dp)+recur(n-2, dp)+recur(n-3, dp);
    // }

    // tabulation
    // public int tribonacci(int n) {
    //     if(n==0){return 0;}
    //     if(n==1){return 1;}
    //     if(n==2){return 1;}
    //     int[] dp = new int[n+1];
    //     dp[0]=0;
    //     dp[1]=1;
    //     dp[2]=1;

    //     for(int i= 3; i<=n; i++){
    //         dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    //     }

    //     return dp[n];
    // }

    // space optimization
    public int tribonacci(int n) {
        if(n==0){return 0;}
        if(n==1){return 1;}
        if(n==2){return 1;}
        int minus3=0;
        int minus2=1;
        int minus1=1;
        int curr = 1;
        for(int i= 3; i<=n; i++){
            curr=minus1+minus2+minus3;
            minus3=minus2;
            minus2 = minus1;
            minus1=curr;
        }

        return curr;
    }
}