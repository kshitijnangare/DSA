
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int n1 = s.length();
        int n2 = t.length();
        int offset = 1;
        int[][] dp = new int[n1+offset][n2+offset];

        for(int i = 0; i<n1; i++){
            dp[i+offset][0]=0;
        }
        for(int j = 0; j<n2; j++){
            dp[0][j+offset]=0;
        }

        for(int i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                char c1 = s.charAt(i);
                char c2 = t.charAt(j);

                if(c1==c2){
                    dp[i+offset][j+offset]=1+dp[i-1+offset][j-1+offset];
                }else{
                    int way1 = dp[i-1+offset][j+offset];
                    int way2 = dp[i+offset][j-1+offset];
                    dp[i+offset][j+offset]= 0 + Math.max(way1, way2);
                }
            }
        }
        return dp[n1-1+offset][n2-1+offset];
    }
}
