class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        map.put(nums[0], 0);
        for(int i = 1; i<nums.length; i++){
            int inSet = target-nums[i];
            if(map.containsKey(inSet)){
                res[0] = i;
                res[1] = map.get(inSet);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}