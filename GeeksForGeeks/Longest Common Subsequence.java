class Solution {
    // static int lcs(String s1, String s2) {
    //     // code here
    //     int n1 = s1.length();
    //     int n2 = s2.length();
    //     return recur(n1-1, n2-1, s1, s2);
    // }
    // static int recur(int i1, int i2, String s1, String s2){
    //     if(i1<0 || i2<0){
    //         return 0;
    //     }
        
    //     char c1 = s1.charAt(i1);
    //     char c2 = s2.charAt(i2);
        
    //     if(c1==c2){
    //         return 1 + recur(i1-1,i2-1,s1,s2);
    //     }else{
    //         int way1 = recur(i1, i2-1, s1, s2);
    //         int way2 = recur(i1-1, i2, s1, s2);
    //         return 0 + Math.max(way1, way2);
    //     }
    // }
    
    // memoization
    // static int lcs(String s1, String s2) {
    //     // code here
    //     int n1 = s1.length();
    //     int n2 = s2.length();
    //     int[][] dp = new int[n1][n2];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n1-1, n2-1, s1, s2, dp);
    // }
    // static int recur(int i1, int i2, String s1, String s2, int[][] dp){
    //     if(i1<0 || i2<0){
    //         return 0;
    //     }
        
    //     if(dp[i1][i2]!=-1){
    //         return dp[i1][i2];
    //     }
        
    //     char c1 = s1.charAt(i1);
    //     char c2 = s2.charAt(i2);
        
    //     if(c1==c2){
    //         return dp[i1][i2] = 1 + recur(i1-1,i2-1,s1,s2, dp);
    //     }else{
    //         int way1 = recur(i1, i2-1, s1, s2, dp);
    //         int way2 = recur(i1-1, i2, s1, s2, dp);
    //         return dp[i1][i2] = 0 + Math.max(way1, way2);
    //     }
    // }
    
    
    // tabulation
    static int lcs(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int offset = 1;
        int[][] dp = new int[n1+offset][n2+offset];
        
        for(int i1 = 0; i1<n1; i1++){
            dp[i1+offset][0] = 0;
        }
        for(int i2 = 0; i2<n2; i2++){
            dp[0][i2+offset] =0;
        }
        
        for(int i1 = 0; i1<n1; i1++){
            for(int i2 = 0; i2<n2; i2++){
                char c1 = s1.charAt(i1);
                char c2 = s2.charAt(i2);
                
                if(c1==c2){
                    dp[i1+offset][i2+offset] = 1 + dp[i1-1+offset][i2-1+offset];
                }else{
                    int way1 = dp[i1+offset][i2-1+offset];
                    int way2 = dp[i1-1+offset][i2+offset];
                    dp[i1+offset][i2+offset] = 0 + Math.max(way1, way2);
                }
            }
        }
        return dp[n1-1+offset][n2-1+offset];
        
    }
    
    
    
}