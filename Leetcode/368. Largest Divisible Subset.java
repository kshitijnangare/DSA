class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
            hash[i]=i;
        }
        
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[i]%nums[prev]==0){
                    if(dp[i] < dp[prev]+1){
                        dp[i]= dp[prev]+1;
                        hash[i]=prev;
                    }
                }
            }
        }
        
        int maxInd=0;
        int max = -1;
        for(int i =0; i<n; i++){
            if(max<dp[i]){
                maxInd = i;
                max = dp[i];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while(hash[maxInd]!=maxInd){
            list.add(nums[maxInd]);
            maxInd = hash[maxInd];
        }
        list.add(nums[maxInd]);
        Collections.reverse(list);
        return list;
    }
}