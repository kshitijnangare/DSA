class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return memo(0,0, triangle, n, dp);
    }
    int memo(int i, int j, ArrayList<ArrayList<Integer>> triangle, int n, int[][] dp){
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int down = memo(i+1, j, triangle, n, dp);
        int diagonal = memo(i+1, j+1, triangle, n, dp);
        return dp[i][j]=triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}