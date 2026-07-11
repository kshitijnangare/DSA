class Solution {
    public int editDistance(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int offset = 1;
        int[][] dp = new int[n+offset][m+offset];
        
        for(int j = -1; j<m; j++){
            dp[-1+offset][j+offset]=j+1;
        }
        for(int i = -1; i<n; i++){
            dp[i+offset][-1+offset]=i+1;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset]=0+dp[i-1+offset][j-1+offset];
                }else{
                    int insert = 1 + dp[i+offset][j-1+offset];
                    int delete = 1 + dp[i-1+offset][j+offset];
                    int replace = 1 + dp[i-1+offset][j-1+offset];
                    dp[i+offset][j+offset]=Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n-1+offset][m-1+offset];
    }
}