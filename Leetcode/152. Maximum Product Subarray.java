class Solution {
    // kadanes algo
    // public int maxProduct(int[] nums) {
    //     int n = nums.length;
    //     int maxEnding = nums[0];
    //     int minEnding = nums[0];
    //     int res = nums[0];

    //     for(int i = 1; i<n; i++){
    //         int curr = nums[i];
    //         int tempMax = Math.max(curr, Math.max(maxEnding*curr, minEnding*curr));
    //         minEnding = Math.min(curr, Math.min(maxEnding*curr, minEnding*curr));
            
    //         maxEnding = tempMax;
    //         res = Math.max(res, maxEnding);
    //     }
    //     return res;
    // }
    
    // intuitive approach, suffix prefix
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(prefix==0){prefix=1;}
            if(suffix==0){suffix=1;}

            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];

            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}