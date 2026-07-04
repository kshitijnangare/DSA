class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minprice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.size(); i++){
            int currProfit = prices[i]-minprice;
            maxProfit = max(maxProfit, currProfit);
            minprice = min(minprice, prices[i]);
        }
        return maxProfit;
    }
};