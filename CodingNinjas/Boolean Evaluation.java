public class Solution {
    public static int evaluateExp(String s) {
        // Write your code here.
        int n = s.length();
        int MOD = 1000000007;
        int[][][] dp = new int[n][n][2];
        
        for(int j = 0; j<n; j++){
            for(int i = n-1; i>j; i--){
                for(int k = 0; k<2; k++){
                    dp[i][j][k]=0;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int k = 0; k<2; k++){
                if(k==1){
                    if(s.charAt(i)=='T'){
                        dp[i][i][k]=1;
                    }else{
                        dp[i][i][k]=0;
                    }
                }else{
                    if(s.charAt(i)=='F'){
                        dp[i][i][k]=1;
                    }else{
                        dp[i][i][k]=0;
                    }
                }
            }
        }
        
        for(int i =n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if((j - i) % 2 == 1) continue;
                for(int isTrue = 0; isTrue<2; isTrue++){
                    long ways = 0;
                    for(int z = i+1; z<j; z=z+2){
                        int leftTrues = dp[i][z-1][1];
                        int leftFalse = dp[i][z-1][0];
                        int rightTrues = dp[z+1][j][1];
                        int rightFalse = dp[z+1][j][0];
                        if(s.charAt(z)=='&'){
                            if(isTrue==1){
                                ways = (ways + ((long)leftTrues * rightTrues)%MOD)%MOD;
                            }else{
                                ways = (ways + ((long)leftFalse*rightTrues)%MOD + ((long)leftTrues*rightFalse)%MOD + ((long)leftFalse*rightFalse)%MOD)%MOD;
                            }
                        }else if(s.charAt(z)=='|'){
                            if(isTrue==1){
                                ways = (ways+((long)leftTrues*rightFalse)%MOD + ((long)leftTrues*rightTrues)%MOD + ((long)leftFalse*rightTrues)%MOD)%MOD;
                            }else{
                                ways = (ways + ((long)leftFalse * rightFalse)%MOD)%MOD;
                            }
                        }else{
                            if(isTrue==1){
                                ways = (ways+ ((long)leftTrues*rightFalse)%MOD+((long)leftFalse*rightTrues)%MOD)%MOD;
                            }else{
                                ways = (ways+((long)leftTrues*rightTrues)%MOD + ((long)leftFalse*rightFalse)%MOD)%MOD;
                            }
                        }
                    }
                    dp[i][j][isTrue]=(int)ways;
                }
            }
        }
        
        return dp[0][s.length()-1][1];
    }
}