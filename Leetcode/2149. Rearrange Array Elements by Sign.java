class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0;
        int pind = 0;
        int nind = 1;
        int[] res = new int[nums.length];

        while(i<nums.length){
            if(nums[i]<0){
                res[nind] = nums[i];
                nind=nind+2;
            }else{
                res[pind]=nums[i];
                pind=pind+2;
            }
            i++;
        }
        return res;
    }
}