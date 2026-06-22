class Solution {

    // memoization
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n1 = text1.length();
    //     int n2 = text2.length();
    //     int[][] dp = new int[n1][n2];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(n1-1, n2-1, text1, text2, dp);
    // }
    // int recur(int i, int j, String s1, String s2, int[][] dp){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);

    //     if(c1==c2){
    //         return dp[i][j]=1+recur(i-1,j-1,s1,s2,dp);
    //     }else{
    //         int way1 = recur(i-1, j, s1,s2,dp);
    //         int way2 = recur(i, j-1, s1,s2,dp);
    //         return dp[i][j]= 0 + Math.max(way1, way2);
    //     }
    // }

    // tabultaion
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int offset = 1;
        int[][] dp = new int[n1+offset][n2+offset];
        
        // if(i<0 || j<0){
        //     return 0;
        // }

        for(int i = 0; i<n1; i++){
            dp[i+offset][0]=0;
        }
        for(int j = 0; j<n2; j++){
            dp[0][j+offset]=0;
        }

        for(int i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);

                if(c1==c2){
                    dp[i+offset][j+offset]=1+dp[i-1+offset][j-1+offset];
                }else{
                    int way1 = dp[i-1+offset][j+offset];
                    int way2 = dp[i+offset][j-1+offset];
                    dp[i+offset][j+offset]= 0 + Math.max(way1, way2);
                }
            }
        }
        return dp[n1-1+offset][n2-1+offset];
    }
}