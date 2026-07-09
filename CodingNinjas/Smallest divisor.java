public class Solution {
    public static int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        int max = Integer.MIN_VALUE;
        for(int x: arr){
            max=Math.max(max, x);
        }

        int high = max; int low = 1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, limit, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    static boolean isPossible(int[] arr, int limit, int n){
        int total = 0;
        for(int x: arr){
            int div = (x + n - 1) / n;
            total = total + div;
        }
        return total<=limit;
    }
}