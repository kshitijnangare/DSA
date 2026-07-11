class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int n1= s1.length();
        int n2= s2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int longest = LCS(n1-1,n2-1, s1, s2, dp);
        return (n1 + n2) - longest;
    }
    static int LCS(int i, int j, String s1, String s2, int[][] dp){
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