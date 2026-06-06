class Solution {
    public int[] leftRightDifference(int[] nums) {
        // this is a simple brute force appraoch
        // Optimization can be done:
        // store the prefix values in num (you know how to
        // store 2 values in a single array slot arr[i]
        // watch out for constraints 
        // then calculate suffix dynmaically and then subtract and store ans in res
        // in this way you need only 2 loops and one res array.
        // no suffix and prefix array needed
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0]=0;
        for(int i = 1; i<n; i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        suffix[n-1]=0;
        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1]+nums[i+1]; 
        }

        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            res[i]=Math.abs(prefix[i]-suffix[i]);
        }
        return res;
    }
}