class Solution {
    public int singleNumber(int[] nums) {
        int once = nums[0];
        for(int i = 1; i<nums.length; i++){
            once = once^nums[i];
        }
        return once;
    }
}