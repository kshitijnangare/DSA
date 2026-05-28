class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k==0 || n==1){
            return;
        }
        reverse(0,n-k-1, nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
    }
    void reverse(int l, int r, int[] nums){
        while(l<r){
            int t = nums[l];
            nums[l]=nums[r];
            nums[r]=t;
            l++;
            r--;
        }
    }
}