class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachedIndex = 0;
        for(int i = 0; i<n; i++){
            if(maxReachedIndex>n-1){
                return true;
            }
            if(maxReachedIndex<i){
                return false;
            }
            maxReachedIndex = Math.max(maxReachedIndex, i+nums[i]);
        }
        return true;
    }
}