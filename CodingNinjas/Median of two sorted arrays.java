public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
        if (a.length > b.length) {
            return median(b, a);
        }
        
        int m = a.length;
        int n = b.length;
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = (m + n + 1) / 2 - i;
            
            int l1 = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int r1 = (i == m) ? Integer.MAX_VALUE : a[i];
            
            int l2 = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int r2 = (j == n) ? Integer.MAX_VALUE : b[j];
            
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        
        return 0.0;
    }
}