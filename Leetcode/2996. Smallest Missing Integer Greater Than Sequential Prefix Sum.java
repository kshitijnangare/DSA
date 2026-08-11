class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int len = 1;
        int sum = nums[0];
        int i = 1;
        while(i<n){
            if(nums[i-1]+1==nums[i]){
                sum+=nums[i];
                i++;
                len++;
            }else{
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}