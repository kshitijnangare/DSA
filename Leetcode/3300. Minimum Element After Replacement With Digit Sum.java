class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int x: nums){
            int digitSum = helper(x);
            min = Math.min(min, digitSum);
        }
        return min;
    }
    public int helper(int x){
        int res = 0;
        while(x!=0){
            int r = x%10;
            x=x/10;
            res+=r;;
        }
        return res;
    }
}