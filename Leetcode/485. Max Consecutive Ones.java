class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currMax=0;
        for(int i :nums){
            if(i==1){
                max = Math.max(max, ++currMax);
            }else{
                currMax=0;
            }
        }
        return max;
    }
}