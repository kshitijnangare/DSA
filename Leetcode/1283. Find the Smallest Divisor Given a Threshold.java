class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int x: nums){
            max=Math.max(max, x);
        }

        int high = max; int low = 1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if(isPossible(nums, threshold, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    boolean isPossible(int[] nums, int threshold, int n){
        int total = 0;
        for(int x: nums){
            int div = (x + n - 1) / n;
            total = total + div;
        }
        return total<=threshold;
    }
}