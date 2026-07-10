import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(n<m){
            return -1;
        }
        long low = 0;
        long high =0;
        for(int x: arr){
            if (x > low) {
                low = x; 
            }
            high = high + x;
        }
        long ans = -1;
        while(low<=high){
            long mid = (low + (high-low)/2);
            if(helper(arr, m, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)ans;
    }
    public static boolean helper(ArrayList<Integer> arr, int k, long mid){
        int count = 1;
        int sum = 0;
        for(int each: arr){
            if(sum+each <=mid){
                sum +=each;
            }else{
                sum = each;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return count<=k;
    }
}