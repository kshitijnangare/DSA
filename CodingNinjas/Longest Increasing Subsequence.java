import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	
    public static int LIS(ArrayList<Integer> heights, int n)  {
        // Write your code here.        
        if (n == 0) return 0;

        int[] arr = new int[n];
        int lastind = 1;
        arr[0] = heights.get(0);
        
        for (int i = 1; i < n; i++) {
            int curr = heights.get(i);
            if (arr[lastind - 1] < curr) {
                arr[lastind] = curr;
                lastind++;
            } else {
                int low = 0;
                int high = lastind - 1; 
                int ans = 0; 
                
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[mid] >= curr) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                arr[ans] = curr;
            }
        }
        return lastind;
    }
}