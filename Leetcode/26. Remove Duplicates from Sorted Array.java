class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int j = 0;
        for(int i = 1; i<len; i++){
            while(i<len && nums[j]==nums[i]){
                i++;
            }
            if(i>=len){
                break;
            }
            nums[j+1]=nums[i];
            j++;
        }
        return j+1;
    }
}