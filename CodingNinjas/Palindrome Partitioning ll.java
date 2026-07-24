public class Solution {
    public static int palindromePartitioning(String s) {
        // Write your code here
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