class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
       int max = Integer.MIN_VALUE;
        for(int x: arr){
            max=Math.max(max, x);
        }

        int high = max; int low = 1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, k, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    boolean isPossible(int[] arr, int k, int n){
        int total = 0;
        for(int x: arr){
            int div = (x + n - 1) / n;
            total = total + div;
        }
        return total<=k;
    }
}