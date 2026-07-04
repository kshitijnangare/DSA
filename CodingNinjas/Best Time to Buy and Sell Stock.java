import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int maxProfit = 0;
        int minPrice = prices.get(0);
        for(int i = 1; i<prices.size(); i++){
            int currProfit = prices.get(i)-minPrice;
            maxProfit=Math.max(maxProfit, currProfit);
            minPrice=Math.min(minPrice, prices.get(i));
        }
        return maxProfit;
    }
}