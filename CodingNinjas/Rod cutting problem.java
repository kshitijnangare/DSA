public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int length = n;
        // dp array of [ind][length]
        int[][] dp = new int[n][length+1];
        
        
        for(int len = 0; len<=length; len++){
            dp[0][len] = len * price[0];
        }
        
        for(int i = 0; i<n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i<n; i++){
            for(int len = 1; len<=length; len++){
                // in not cut curr len price will not get added and the length of the 
                // rod will also not reduce
                int notCut = 0 + dp[i-1][len];
                int cut=0; // let it be zero first
                if(len >= i+1){ // len should be greater than i+1 always
                // profit of price[i] will get added and we can again cut with the same length
                // infinite supply rule problem
                    cut = price[i] + dp[i][len-(i+1)];
                    //len reduced by (i+1) size
                }
                dp[i][len] = Math.max(cut, notCut);// return max
            }
        }
        return dp[n-1][length];
	}
}