class Solution {
	// public int longestSubseq(int[] arr) {
	//     // code here
	//     int n = arr.length;
	//     int[][] dp = new int[n+1][n+1];
	//     for(int[] row : dp){
	//         Arrays.fill(row,-1);
	//     }
	//     return recur(n-1, n, arr, dp);
	// }
	// int recur(int i, int pi, int[] arr, int[][] dp){
	//     if(i<0){
	//         return 0;
	//     }
	//     if(pi!=arr.length && dp[i][pi]!=-1){
	//         return dp[i][pi];
	//     }
	
	//     // we have 2 options either choose or not choose
	//     // but these options are not simple they are conditional
	//     // not choose: not condition. so we can decide not to choose a index without any condition
	//     // choose: only if Math.abs(prev-curr)==1 then only we can choose else we cant choose;
	
	//     // in not choose length does not get added and pi stays same
	//     int notChooseLength = 0 + recur(i-1, pi, arr, dp);
	//     int chooseLength = Integer.MIN_VALUE; // since its longest initiate as smallest
	//     if(pi==arr.length || Math.abs(arr[i]-arr[pi])==1){
	//         chooseLength = 1 + recur(i-1, i, arr, dp);
	//     }
	//     return dp[i][pi]=Math.max(notChooseLength, chooseLength);
	// }
	
	// public int longestSubseq(int[] arr) {
	//     // code here
	//     int n = arr.length;
	//     int offset = 1;
	//     int[] prev = new int[n+1];
	//     for(int i = 0; i < n; i++) {
	//         int[] curr = new int[n + 1];
	//         for(int pi = 0; pi <= n; pi++) {
	//             // Not choose
	//             int notChoose = prev[pi];
	//             int choose = Integer.MIN_VALUE;
	//             // Choose
	//             if(pi == n || Math.abs(arr[i] - arr[pi]) == 1) {
	//                 choose = 1 + prev[i];
	//             }
	//             curr[pi] = Math.max(notChoose, choose);
	//         }
	//         prev = curr;
	//     }
	//     return prev[n];
	// }
	
	public int longestSubseq(int[] arr) {
		// code here
		int n = arr.length;
		if (n == 1) {
			return 1;
		}
		HashMap<Integer, Integer> dp = new HashMap<>();
		int ans = 1;
		for (int i = 0; i < n; ++i) {
			if (dp.containsKey(arr[i] + 1) || dp.containsKey(arr[i] - 1)) {
				
				dp.put(arr[i], 1 + Math.max(dp.getOrDefault(arr[i] + 1, 0), dp.getOrDefault(arr[i] - 1, 0)));
			}
			else {
				dp.put(arr[i], 1);
			}
			ans = Math.max(ans, dp.get(arr[i]));
		}
		return ans;
	}
}
