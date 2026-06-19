class Solution {

    // prefix and suffix sum
    // public int countPartitions(int[] nums) {
    //     int n = nums.length;
    //     int[] prefix = new int[n+1];
    //     int[] suffix = new int[n+1];

    //     int sum = 0;
    //     prefix[0]=sum;
    //     for(int i = 0; i<n; i++){
    //         sum = sum + nums[i];
    //         prefix[i+1]=sum;
    //     }
    //     sum = 0;
    //     suffix[n]=sum;
    //     for(int i = n-1; i>=0; i--){
    //         sum = sum + nums[i];
    //         suffix[i]=sum;
    //     }
    //     int count = 0;
    //     for(int i =1 ; i<=n-1; i++){
    //         if(Math.abs(suffix[i]-prefix[i]) %2==0 ){
    //             count++;
    //         }
    //     }
    //     return count;
    // }


    // approach 2: very simple parity check
    // left = sum of left subarray
    // right = sum of right subarray
    // total = left + right
    // hence right = total - left
    // we want 
    // left-right = even
    // left - (total - left) = even
    // left - total + left = even
    // 2 * left - total = even
    // Now 
    // any number (odd/even) * 2 = even number only
    // hence
    // even1 - total = even
    // even1-even = total
    // any even - even is always a even
    // hence total should be even (total = even)
    // if total is even then every possible partition is valid. The number of possible partitions in an array of length n is: n - 1 because the split can occur between any two consecutive elements. hence return n-1 else return 0



    public int countPartitions(int[] nums) {
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return 0;
        }

        return nums.length - 1;
    }
}