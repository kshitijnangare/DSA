class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int len = 0;
        int x = k;
        int high = 0;
        int low = 0;
        while(high<nums.length){
            int n = nums[high];
            if(n==1){
                len++;
                max = Math.max(max, len);
                high++;
            }else{
                if(x==0){
                    len--;
                    if(nums[low]==0){
                        x++;
                    }
                    low++;
                }else{
                    len++;
                    max = Math.max(max, len);
                    high++;
                    x--;
                }
            }
        }
        return max;
    }
}