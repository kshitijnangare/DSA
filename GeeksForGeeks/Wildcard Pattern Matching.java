class Solution {
    public boolean wildCard(String txt, String pat) {
        // code here
        int n2 = txt.length();
        int n1 = pat.length();
        int offset = 1;
        Boolean[][] dp = new Boolean[n1+offset][n2+offset];

        dp[-1+offset][-1+offset]=true;
        for(int j = 0;j<n2; j++){
            dp[-1+offset][j+offset]=false;
        }
        int i = 0;
        while(i<n1 && pat.charAt(i)=='*'){
            dp[i+offset][-1+offset]=true;
            i++;
        }
        while(i<n1){
            dp[i+offset][-1+offset]=false;
            i++;
        }

        for(i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                char c1 = pat.charAt(i);
                char c2 = txt.charAt(j);
                if(c1==c2 || c1=='?'){
                    dp[i+offset][j+offset]=dp[i-1+offset][j-1+offset];
                }else if(c1=='*'){
                    boolean way1 = dp[i+offset][j-1+offset];
                    boolean way2 = dp[i-1+offset][j+offset];
                    dp[i+offset][j+offset] = (way1 || way2);
                }else{
                    dp[i+offset][j+offset]=false;
                }
            }
        }
        
        return dp[n1-1+offset][n2-1+offset];
    }
}