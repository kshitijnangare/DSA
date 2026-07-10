import java.util.ArrayList;
public class Solution {
    public static int splitArray(ArrayList<Integer> array, int k) {
        // Write your code here.
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int x: array){
            high = high + x;
            low = Math.max(low, x);
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(helper(array, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean helper(ArrayList<Integer> array, int k, int mid){
        int count = 1;
        int sum = 0;
        for(int x: array){
            if(sum+x<=mid){
                sum+=x;
            }else{
                count++;
                sum = x;
            }
        }
        return count<=k;
    }
}