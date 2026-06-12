class Solution {
    int maxProduct(int[] arr) {
        // code here
    int n = arr.length;
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int res = arr[0];

        for(int i = 1; i<n; i++){
            int curr = arr[i];
            int tempMax = Math.max(curr, Math.max(maxEnding*curr, minEnding*curr));
            minEnding = Math.min(curr, Math.min(maxEnding*curr, minEnding*curr));
            
            maxEnding = tempMax;
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
