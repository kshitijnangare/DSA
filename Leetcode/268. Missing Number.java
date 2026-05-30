class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            actualSum=actualSum+i+1;
            sum = sum+nums[i];
        }
        return actualSum-sum;

    }
}