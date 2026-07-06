public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.
        int offset = 1;
        int [][]dp = new int[n+offset][m+offset];

        for(int i = -1; i<n; i++){
            dp[i+offset][0] = 0;
        }
        for(int j = -1; j<m; j++){
            dp[0][j+offset]=0;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i + offset][j+offset] = 1 + dp[i+offset-1][j+offset-1];
                }else{
                    int way1 = dp[i-1+offset][j+offset];
                    int way2 = dp[i+offset][j-1+offset];
                    dp[i+offset][j+offset]=Math.max(way1,way2);
                }
            }
        }

        int i = n-1; int j = m-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if(c1==c2){
                sb.append(c1);
                i--;
                j--;
            }else{
                if( dp[i+offset][j]==dp[i+offset][j+offset] ){
                    j--;
                }else{
                    i--;
                }
            }
        }
        sb.reverse();
        return sb.toString();

    }
}