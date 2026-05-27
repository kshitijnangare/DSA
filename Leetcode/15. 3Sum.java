class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<n-2; i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int currTarget = target-nums[i];
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum == currTarget){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l]==nums[l+1]){l++;}
                    while(l<r && nums[r]==nums[r-1]){r--;}
                    l++;
                    r--;
                }else if(sum<currTarget){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}