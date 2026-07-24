class Solution {
    // public int minCut(String s) {
    //     return recur(0, s)-1;
    // }
    // int recur(int i , String s){
    //     if(i==s.length()){
    //         return 0;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     StringBuilder sb = new StringBuilder();
    //     for(int j = i; j<s.length(); j++){
    //         sb = new StringBuilder(s.substring(i,j+1));
    //         if(isPalindrome(sb)){
    //             int ops = 1 + recur(j+1, s);
    //             min = Math.min(min, ops);
    //         }
    //     }
    //     return min;
    // }
    // boolean isPalindrome(StringBuilder sb){
    //     int n = sb.length();
    //     int l = 0;
    //     int r = n-1;
    //     while(l<r){
    //         if(sb.charAt(l)!=sb.charAt(r)){
    //             return false;
    //         }
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }

    // memoization
    // public int minCut(String s) {
    //     int n = s.length();
    //     int[] dp = new int[n];
    //     boolean isPal[][] = new boolean[n][n];

    //     for(int i =n-1; i>=0;i--){
    //         for(int j = i; j<n; j++){
    //             if(s.charAt(i)==s.charAt(j)){
    //                 if (j-i <= 2) {
    //                     isPal[i][j] = true;
    //                 }else {
    //                     isPal[i][j] = isPal[i + 1][j - 1];
    //                 }
    //             }else{
    //                 isPal[i][j]=false;
    //             }
    //         }
    //     }

    //     Arrays.fill(dp, -1);
    //     return recur(0, s, dp, isPal)-1;
    // }
    // int recur(int i , String s, int[] dp, boolean[][] isPal){
    //     if(i==s.length()){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(int j = i; j<s.length(); j++){
    //         if(isPal[i][j]){
    //             int ops = 1 + recur(j+1, s, dp, isPal);
    //             min = Math.min(min, ops);
    //         }
    //     }
    //     return dp[i] = min;
    // }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        boolean isPal[][] = new boolean[n][n];

        for(int i =n-1; i>=0;i--){
            for(int j = i; j<n; j++){
                if(s.charAt(i)==s.charAt(j)){
                    if (j-i <= 2) {
                        isPal[i][j] = true;
                    }else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }else{
                    isPal[i][j]=false;
                }
            }
        }
        dp[n]=0;
        for(int i = n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i; j<s.length(); j++){
                if(isPal[i][j]){
                    int ops = 1 + dp[j+1];
                    min = Math.min(min, ops);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }
}