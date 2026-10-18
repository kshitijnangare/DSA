class Solution {
    public int minDeletions(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 1; i<n; i++){
            int prev = nums[i-1];
            int curr = nums[i];
            if(prev==curr){
                count++;
            }
        }
        return count;
    }
}
