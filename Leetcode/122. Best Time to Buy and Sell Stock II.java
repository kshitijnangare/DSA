class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        for(int i = 1; i<prices.size(); i++){
            int prev = prices[i-1];
            int curr = prices[i];
            if(prev<curr){
                profit = profit + (curr-prev);
            }
        }
        return profit;
    }
};