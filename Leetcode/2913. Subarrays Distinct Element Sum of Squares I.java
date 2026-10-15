class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(nums.get(i));
            ans+= Math.pow(set.size(), 2);
            for(int j = i+1; j<n; j++){
                set.add(nums.get(j));
                ans+= Math.pow(set.size(), 2);
            }
        }
        return ans;
    }
}

// This is brute force approach which works for the given contraints.
// but it will fail for large constraints