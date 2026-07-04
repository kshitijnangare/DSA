class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int breakInd = n;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                breakInd=i;
                break;
            }
        }
        if(breakInd==n){
            sort(nums.begin(), nums.end());
            return;
        }
        int immediateGreater = INT_MAX;
        int swapInd = -1;
        for(int i = breakInd+1; i<n; i++){
            if(nums[i]>nums[breakInd]){
                if(immediateGreater>nums[i]){
                    immediateGreater = nums[i];
                    swapInd = i;
                }
            }
        }
        if(swapInd==-1){return;}
        int t = nums[swapInd];
        nums[swapInd] = nums[breakInd];
        nums[breakInd]=t;

        sort(nums.begin()+breakInd+1, nums.end());
        return;

    }
};