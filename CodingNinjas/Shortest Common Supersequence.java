import java.util.* ;
import java.io.*; 
public class Solution {
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int n1= a.length();
        int n2= b.length();
        int offset = 1;
        int[][] dp = new int[n1+offset][n2+offset];
        
        for(int i = -1; i<n1; i++){
            dp[i+offset][0]=0;
        }
        for(int j = -1; j<n2; j++){
            dp[0][j+offset]=0;
        }

        for(int i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                char c1 = a.charAt(i);
                char c2 = b.charAt(j);
                if(c1==c2){
                    dp[i+offset][j+offset]= 1 + dp[i-1+offset][j-1+offset];
                }else{
                    int way1= dp[i-1+offset][j+offset];
                    int way2 = dp[i+offset][j-1+offset];
                    dp[i+offset][j+offset]=Math.max(way1, way2);
                }
            }
        }

        int i = n1+offset-1;
        int j = n2+offset-1;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            int left = dp[i][j-1];
            int up = dp[i-1][j];
            int diag = dp[i-1][j-1];
            if(dp[i][j]==left){
                sb.append(b.charAt(j-offset));
                j--;
            }else if(dp[i][j]==up){
                sb.append(a.charAt(i-offset));
                i--;
            }else{
                sb.append(a.charAt(i-offset));
                i--;
                j--;
            }
        }
        while(i>0){
            sb.append(a.charAt(i-offset));
            i--;
        }
        while(j>0){
            sb.append(b.charAt(j-offset));
            j--;
        }
        return sb.reverse().toString();
    }

}