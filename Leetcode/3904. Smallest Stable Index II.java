class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        int max = nums[0];
        pre[0]=max;
        for(int i = 1; i<n; i++){
            max = Math.max(max, nums[i]);
            pre[i]=max;
        }
        int min = nums[n-1];
        suf[n-1]=min;
        for(int i = n-2; i>=0; i--){
            min = Math.min(min, nums[i]);
            suf[i]=min;
        }

        for(int i =0; i<n; i++){
            if(pre[i]-suf[i]<=k){
                return i;
            }
        }
        return -1;
    }
}