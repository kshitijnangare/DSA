class Solution {
    // Approach 1
    // ----------------------------------------------------------------
    // My intital thinking:
    // we need two parameters index, target in the recursion function
    // at every step there will be 2 options on index, either add it or subtract it
    // here by adding it means we will subtract it from target and subtract it means add it from target
    // note here no base case on target since we anyhow have to traverse the entire array from n-1 to zero
    // index i goes from n-1 to 0
    // no matter what there will be a sign before every number. that is compulsory

    // fist going ahead with recursion approach
    // public int findTargetSumWays(int[] nums, int target) {
    //     return recur(nums.length-1, target, nums);
    // }
    // int recur(int i, int target, int[] nums){
    //     if(i==0){
    //         if(nums[i]+target==0 || nums[i]-target==0){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     int add = recur(i-1, target-nums[i], nums);
    //     int subtract = recur(i-1, target+nums[i], nums);
    //     return add+subtract;
    // }


    //  now memoization
    // look at the constraints it says target is from -1000 to 1000
    // and nums[i] is frrom 0 to 1000
    // also total sum cannot exceed 1000
    

    // public int findTargetSumWays(int[] nums, int target) {
    //     // intiialize DP (only 1 state will be there? yes since target value is evaluated only at last index)
    //     int offset = 1000;
    //     int[][] dp = new int[nums.length][2001];
    //     // -1 filling
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return recur(nums.length-1, target, nums, dp, offset);
    // }
    // int recur(int i, int target, int[] nums, int[][] dp, int offset){
    //     // Corner case safety: if target goes out of possible constraints bounds
    //     if(target < -1000 || target > 1000){
    //         return 0;
    //     }

    //     if(i==0){
    //         // Special case: if nums[0] is 0, both +0 and -0 equal 0.
    //         // If target is 0, it satisfies both paths, yielding 2 ways.
    //         if(nums[i] == 0 && target == 0){
    //             return 2;
    //         }

    //         if(nums[i]+target==0 || nums[i]-target==0){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     // Use offset to safely read from the array row
    //     if(dp[i][target + offset] != -1){
    //         return dp[i][target + offset];
    //     }

    //     int add = recur(i-1, target-nums[i], nums, dp, offset);
    //     int subtract = recur(i-1, target+nums[i], nums, dp, offset);
    //     return dp[i][target+offset] = add+subtract;
    // }
    // ----------------------------------------------------------------


    // Appraoch 2
    // This solution can become a solution of Subset Sum Equals K Problem
    // Explaination:
    // Think of dividing the array into two groups which correctly gives target: 
    // S1: The numbers assigned + sign.
    // S2: The numbers assigned - sign.
    // Now think again and we get the following:
    // S1 - S2 = target (positive part - negative part)
    // S1 + S2 = totalSum of the array
    
    // add the equations we get
    // 2 x S1 = target + totalSum
    // S1 = (target + totalSum) / 2

    // The problem shifts completely: Find how many subsets sum up to exactly S1.
    // Since S1 is strictly positive, we can use the existing soluiton only.

    // memoization for apprach 2

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int x : nums){
            totalSum += x;
        }
        
        // Edge Cases Check: target cannot be larger than total possible sum,
        // and (target + totalSum) must be an even number to divide by 2 perfectly.
        if(Math.abs(target) > totalSum || (target + totalSum) % 2 != 0){
            return 0;
        }
        
        int s1 = (target + totalSum) / 2;
        int n = nums.length;
        
        // dp[i][j] will store the number of ways to make sum 'j' using elements up to index 'i'
        int[][] dp = new int[n][s1 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return recur(n - 1, s1, nums, dp);
    }
    
    int recur(int i, int sum, int[] nums, int[][] dp){
        // Base Case 1: When we reach the first element
        if(i == 0){
            // Special case for zero: if nums[0] is 0 and our remaining target sum is 0,
            // we can either pick it (+0/-0) or not pick it. Both give sum 0, so 2 ways.
            if(nums[0] == 0 && sum == 0){
                return 2;
            }
            // If the element matches the remaining sum, or if sum is 0 (by picking nothing)
            if(sum == 0 || nums[0] == sum){
                return 1;
            }
            return 0;
        }
        
        // Check if the state has already been calculated
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        // Choice 1: Do not pick the current element
        int notPick = recur(i - 1, sum, nums, dp);
        
        // Choice 2: Pick the current element (only if it fits within the remaining sum)
        int pick = 0;
        if(nums[i] <= sum){
            pick = recur(i - 1, sum - nums[i], nums, dp);
        }
        
        // Cache the combined results into our DP matrix
        return dp[i][sum] = pick + notPick;
    }

}