class Solution {

    // recursion
    // public boolean isMatch(String s, String p) {
    //     int n = s.length();
    //     int m = p.length();
    //     return recur(m-1, n-1, p, s);
    // }
    // boolean recur(int i, int j, String s1, String s2){
    //     if(i<0 && j<0){
    //         return true;
    //     }
    //     if(i<0){
    //         return false;
    //     }
    //     if(j<0){
    //         for(int k = 0; k<=i; k++){
    //             if(s1.charAt(k)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2 || c1=='?'){
    //         return recur(i-1, j-1, s1, s2);
    //     }else if(c1=='*'){
    //         boolean way1 = recur(i, j-1, s1, s2);
    //         boolean way2 = recur(i-1, j, s1, s2);
    //         return way1 || way2;
    //     }else{
    //         return false;
    //     }
    // }

    // memoization
    // public boolean isMatch(String s, String p) {
    //     int n2 = s.length();
    //     int n1 = p.length();
    //     Boolean[][] dp = new Boolean[n1][n2];
    //     return recur(n1-1, n2-1, p, s, dp);
    // }
    // boolean recur(int i, int j, String s1, String s2, Boolean[][] dp){
    //     if(i<0 && j<0){
    //         return true;
    //     }
    //     if(i<0){
    //         return false;
    //     }
    //     if(j<0){
    //         for(int k = 0; k<=i; k++){
    //             if(s1.charAt(k)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }
    //     char c1 = s1.charAt(i);
    //     char c2 = s2.charAt(j);
    //     if(c1==c2 || c1=='?'){
    //         return dp[i][j]=recur(i-1, j-1, s1, s2, dp);
    //     }else if(c1=='*'){
    //         boolean way1 = recur(i, j-1, s1, s2, dp);
    //         boolean way2 = recur(i-1, j, s1, s2, dp);
    //         return dp[i][j] = (way1 || way2);
    //     }else{
    //         return dp[i][j]=false;
    //     }
    // }

    // tabulation
    public boolean isMatch(String s, String p) {
        int n2 = s.length();
        int n1 = p.length();
        int offset = 1;
        Boolean[][] dp = new Boolean[n1+offset][n2+offset];

        dp[-1+offset][-1+offset]=true;
        for(int j = 0;j<n2; j++){
            dp[-1+offset][j+offset]=false;
        }
        int i = 0;
        while(i<n1 && p.charAt(i)=='*'){
            dp[i+offset][-1+offset]=true;
            i++;
        }
        while(i<n1){
            dp[i+offset][-1+offset]=false;
            i++;
        }

        for(i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                char c1 = p.charAt(i);
                char c2 = s.charAt(j);
                if(c1==c2 || c1=='?'){
                    dp[i+offset][j+offset]=dp[i-1+offset][j-1+offset];
                }else if(c1=='*'){
                    boolean way1 = dp[i+offset][j-1+offset];
                    boolean way2 = dp[i-1+offset][j+offset];
                    dp[i+offset][j+offset] = (way1 || way2);
                }else{
                    dp[i+offset][j+offset]=false;
                }
            }
        }
        
        return dp[n1-1+offset][n2-1+offset];
    }
}