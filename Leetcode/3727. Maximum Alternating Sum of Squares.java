class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int m = n/2;
        int p = n- m;

        for(int i = 0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        long minussum = 0;
        for(int i =0; i<m; i++){
            minussum+= Math.pow(nums[i], 2);
        }
        long plussum = 0;
        for(int i =m; i<n; i++){
            plussum+= Math.pow(nums[i], 2);
        }

        long max = plussum-minussum;
        return max;
    }
}

// my thinking
// firstly 
// if n = 6 then there will be 3 terms to plus and 3 to minus
// if n = 5 then there will 3 terms to plus and 2 terms to minus
// n/2 --> minus terms --> m
// n - n/2 --> plus terms --> p

// make all the elements +ve in the array
// sort it
// then choose last p terms