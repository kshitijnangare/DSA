public class Solution {
    public static int maxSubarraySum(int[] arr, int n) {
        // Write your code here.
        int totalSum = 0;
        for(int x: arr){
            totalSum+=x;
        }

        int part1 = maxSubarraySum(arr);
        if(part1<0){
            return part1;
        }

        int part2 = totalSum - minSubarraySum(arr);
        return Math.max(part1, part2);
    }
    static int minSubarraySum(int[] nums){
        int minEnding = nums[0];
        int res = nums[0];
        for(int i = 1; i<nums.length; i++){
            minEnding = Math.min(minEnding+nums[i], nums[i]);
            res = Math.min(res,minEnding);
        }
        return res;
    }
    static int maxSubarraySum(int[] nums){
        int maxEnding = nums[0];
        int res = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            maxEnding = Math.max(maxEnding+nums[i], nums[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }
}
