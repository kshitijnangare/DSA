public class Solution {
    public static int stockProfit(int[] prices) {
        // Write your code here.
        int[] ahead2 = new int[2];
        int[] ahead1 = new int[2];
        int[] curr = new int[2];
        int n = prices.length;
        ahead2[0]=0;
        ahead2[1]=0;
        ahead1[0]=0;
        ahead1[1]=0;

        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<2; buy++){
                if(buy==1){
                    int buystock = ahead1[0] - prices[i];
                    int dontbuystock = ahead1[1];
                    curr[buy] = Math.max(buystock, dontbuystock);
                }else{
                    int sellstock = prices[i] + ahead2[1];
                    int dontsellstock = ahead1[0];
                    curr[buy] = Math.max(sellstock, dontsellstock);
                }
            }
            ahead2 = ahead1;
            ahead1 = curr;
            curr = new int[2];
        }

        return ahead1[1];
    }
}
