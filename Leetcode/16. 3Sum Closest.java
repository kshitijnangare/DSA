class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i = 0; i<n-2; i++){
            int l = i+1;
            int r = n-1;
            
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(res-target) > Math.abs(sum-target)){
                    res = sum;
                }
                if(sum == target){
                    return sum;
                }
                else if(sum<target){
                    l++;
                }else{
                    r--;
                }
            }

        }
        return res;
    }
}