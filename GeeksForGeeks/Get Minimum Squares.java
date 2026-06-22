class Solution {
    public int minSquares(int n) {
        // Code here
        
    ArrayList<Integer> sqarr = new ArrayList<>();
        int sq = 1;
        while(sq*sq<=n){
            sqarr.add(sq*sq);
            sq++;
        }
        int len = sqarr.size();
        int[][] dp = new int[len][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recur(len-1, n, sqarr, dp);
    }
    int recur(int i, int num, ArrayList<Integer> sqarr, int[][] dp){
        if(i==0){
            if(num % sqarr.get(i) ==0){
                return num / sqarr.get(i);
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(num==0){
            return 0;
        }

        if(dp[i][num]!=-1){
            return dp[i][num];
        }

        int notPick = 0 + recur(i-1, num, sqarr, dp);
        int pick = Integer.MAX_VALUE;
        if(num >= sqarr.get(i)){
            pick = 1 + recur(i, num-sqarr.get(i), sqarr, dp);
        }
        return dp[i][num]=Math.min(pick, notPick);
    }
}