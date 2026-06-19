import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> res = new ArrayList<>();
        for(int i=8; i>=0; i--){
            if(n==0){
                break;
            }
            while(n >= denominations[i]){
                res.add(denominations[i]);
                n = n-denominations[i];
            }
        }
        return res;
    }
}
