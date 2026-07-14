class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i = 0; i<n; i++){
            dp1[i]=1;
            dp2[n-1-i]=1;
        }
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp1[i]= Math.max(dp1[i], 1+dp1[j]);
                }
            }
        }
        // reverse LIS
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i], 1+dp2[j]);
                }
            }
        }
        
        int max = 0;
        for(int i =0; i<n; i++){
            if(dp1[i]>1 && dp2[i]>1){
                max = Math.max(max, dp1[i]+dp2[i]-1);
            }
        }
        return n-max;
    }
}