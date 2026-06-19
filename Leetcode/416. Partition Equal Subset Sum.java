class Solution {
    public boolean canPartition(int nums[]) {
        int sum = 0;
		for(int x: nums){
			sum+=x;
		}
		if(sum %2==1){
			return false;
		}
		int k = sum/2;
        int i = nums.length-1;
        int[][] dp = new int[nums.length][k+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(i, k, nums, dp);
    }
    
    Boolean recur(int i, int sum, int[] nums, int[][] dp){
        if(sum<0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(i==0){
            return nums[i]==sum;
        }
        if(dp[i][sum] != -1){
            if(dp[i][sum]==1) return true;
            else return false;
        }
        
        boolean pick = recur(i-1, sum-nums[i], nums, dp);
        boolean notPick = recur(i-1, sum, nums, dp);
        if(pick || notPick){
            dp[i][sum]=1;
        }else{
            dp[i][sum]=0;
        }
        return pick || notPick;
    }
}