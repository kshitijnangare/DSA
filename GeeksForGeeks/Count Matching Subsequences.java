class Solution {
    static int MOD = 1000000007;
    public static int countWays(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(n1-1, n2-1, s1, s2, dp);
    }
    static int recur(int i, int j, String s1, String s2, int[][] dp){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1==c2){
            int way1 = recur(i-1, j-1,s1,s2, dp); // use character
            int way2 = recur(i-1, j, s1, s2, dp); // ignore from s1
            return dp[i][j]=(way1 + way2)%MOD;
        }else{
            return dp[i][j] = recur(i-1,j, s1,s2, dp); // skip from s1
        }
    }
}
