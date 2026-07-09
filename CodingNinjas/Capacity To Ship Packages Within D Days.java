import java.util.* ;
import java.io.*; 
public class Solution {
    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
    int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int x: weights){
            max = Math.max(max, x);
            sum = sum + x;
        }
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(helper(weights, d, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    static boolean helper(int[] w, int d, int capacity){
        int actualDays = 1;
        int sum = 0;
        for(int x: w){
            if(sum+x<=capacity){
                sum += x;
            }else{
                sum = x;
                actualDays++;
            }
        }
        return actualDays<=d;
    }
}