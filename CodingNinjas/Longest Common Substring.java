public class Solution {
    public static int lcs(String s1, String s2){
        // Write your code here.
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        int offset = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset] = 1 + dp[i-1+offset][j-1+offset];
                    ans = Math.max(ans, dp[i+offset][j+offset]);
                }else{
                    dp[i+offset][j+offset]=0;
                }
            }
        }
        return ans;
    }
}
