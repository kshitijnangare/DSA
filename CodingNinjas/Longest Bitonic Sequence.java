public class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i = 0; i<n; i++){
            dp1[i]=1;
            dp2[n-1-i]=1;
        }
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp1[i]= Math.max(dp1[i], 1+dp1[j]);
                }
            }
        }
        // reverse LIS
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(arr[j]<arr[i]){
                    dp2[i]=Math.max(dp2[i], 1+dp2[j]);
                }
            }
        }
        
        int max = 0;
        for(int i =0; i<n; i++){
                max = Math.max(max, dp1[i]+dp2[i]-1);
        }
        return max;
    }
}
