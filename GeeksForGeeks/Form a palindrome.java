class Solution {
    int findMinInsertions(String s) {
        // code here
        String s2 = new StringBuilder(s).reverse().toString();
        int n= s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int longest = LCS(n-1,n-1, s, s2, dp);
        return n - longest;
    }
    int LCS(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1==c2){
            return dp[i][j]=1+LCS(i-1,j-1, s1, s2, dp);
        }else{
            int way1= LCS(i-1, j, s1, s2, dp);
            int way2 = LCS(i, j-1, s1, s2, dp);
            return dp[i][j]=Math.max(way1, way2);
        }
    }
}