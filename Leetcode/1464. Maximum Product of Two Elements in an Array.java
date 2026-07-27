class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==2){return (nums[0]-1)*(nums[1]-1); }
        int max = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;
        for(int x: nums){
            if(x>max){
                secmax = max;
                max = x;
            }else if(x> secmax && x<=max){
                secmax = x;
            }
        }
        // if(secmax == Integer.MIN_VALUE){
        //     secmax = max;
        // }
        return (max-1)*(secmax-1);
    }
}