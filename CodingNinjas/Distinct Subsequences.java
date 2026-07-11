public class Solution {
    static final int MOD = 1000000007;
    public static int distinctSubsequences(String str, String sub) {
        // Write your code here.
        int n = str.length();
        int m = sub.length();
        int offset = 1;
        long[][] dp = new long[n+offset][m+offset];
        for(int i = -1; i<n; i++){
            dp[i+offset][-1+offset]=1;
        }
        for(int j = 0; j<m; j++){
            dp[-1+offset][j+offset]=0;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = str.charAt(i);
                char c2 = sub.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset]=(dp[i-1+offset][j-1+offset] + dp[i-1+offset][j+offset])%MOD;
                }else{
                    dp[i+offset][j+offset]=dp[i-1+offset][j+offset]%MOD;
                }
            }
        }
        return (int)dp[n-1+offset][m-1+offset];
    }
}