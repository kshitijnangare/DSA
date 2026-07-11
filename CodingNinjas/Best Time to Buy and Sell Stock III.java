public class Solution {
    public static int maxProfit(int[] prices) {
        // Write your code here.
        int n = prices.length;
        int cap = 2;
        // int[][][] dp = new int[n+1][2][cap+1];
        int[][] ahead = new int[2][cap+1];
        int[][] curr = new int[2][cap+1];
        for(int i =0; i<=n; i++){
            for(int buy = 0; buy<2; buy++){
                ahead[buy][0]=0;
            }
        }

        for(int buy = 0; buy<2; buy++){
            for(int c = cap; c>=0; c--){
                ahead[buy][cap]=0;
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                for(int c = 1; c<=cap; c++){
                    if(buy==1){
                        int buystock = ahead[0][c] - prices[i];
                        int dontbuystock = ahead[1][c];
                        curr[buy][c]=Math.max(buystock, dontbuystock);
                    }else{
                        int sellstock = ahead[1][c-1] + prices[i];
                        int dontsellstock = ahead[0][c];
                        curr[buy][c]=Math.max(sellstock, dontsellstock);
                    }
                }
            }
            ahead = curr;
        }

        return ahead[1][2];
    }
}