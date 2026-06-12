// User function Template for Java

class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int minEnding = a[0];
        int res = a[0];
        for(int i = 1; i<size; i++){
            minEnding = Math.min(minEnding+a[i], a[i]);
            res = Math.min(res, minEnding);
        }
        return res;
    }
}