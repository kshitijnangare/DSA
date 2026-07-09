class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for(int x: arr){
            high = Math.max(high, x);
            low = Math.min(low, x);
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, mid, m, k)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int[] arr, int day, int m, int k){
        int count = 0;
        int bouquets = 0;

        for (int bloom : arr) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++; 
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}