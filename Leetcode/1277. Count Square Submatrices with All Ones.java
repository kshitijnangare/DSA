class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int r[]: dp){
            Arrays.fill(r, 0);
        }
        int sum = 0;
        for(int i =  0; i<row; i++){
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for(int j = 1; j<col; j++){
            dp[0][j]=matrix[0][j];
            sum+=dp[0][j];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1;j<col; j++){
                if(matrix[i][j]==1){
                    int min = Integer.MAX_VALUE;
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diag = dp[i-1][j-1];
                    min = Math.min(up, Math.min(left, diag));
                    dp[i][j]=min+1;
                }else{
                    dp[i][j]=0;
                }
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}