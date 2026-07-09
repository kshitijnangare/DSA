class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for(int x: bloomDay){
            high = Math.max(high, x);
            low = Math.min(low, x);
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, mid, m, k)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
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