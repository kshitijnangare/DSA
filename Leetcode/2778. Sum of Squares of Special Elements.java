class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i =0; i<n; i++){
            int ind = i+1;
            int num = nums[i];
            if(n % ind==0){
                sum += num * num;
            }
        }
        return sum;
    }
}