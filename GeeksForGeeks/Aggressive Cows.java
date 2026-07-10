class Solution {
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public boolean canPlace(int[] arr, int k, int d) {
        int count = 1;
        int lastPos = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPos >= d) {
                count++;
                lastPos = arr[i];
            }
            if (count >= k) return true;
        }
        return false;
    }

}