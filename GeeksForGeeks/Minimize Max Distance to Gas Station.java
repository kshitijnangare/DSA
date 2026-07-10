class Solution {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        double low = 0.0;
        double high = 0.0;

        for (int i = 0; i < n - 1; i++) {
            double diff = (double)(stations[i + 1] - stations[i]);
            high = Math.max(high, diff);
        }

        for (int iter = 0; iter < 80; iter++) {
            double mid = low + (high - low) / 2.0;
            
            if (helper(stations, K, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
    static boolean helper(int[] arr, int k, double mid){
        int stationsPlaced = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            double gap = arr[i + 1] - arr[i];
            int needed = (int)(gap / mid);
            
            if (gap / mid == needed) {
                needed--;
            }
            
            stationsPlaced += needed;
            if (stationsPlaced > k) {
                return false;
            }
        }
        
        return true;
    }
}
