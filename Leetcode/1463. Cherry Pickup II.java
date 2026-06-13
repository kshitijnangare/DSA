class Solution {
    // recursion 
    // int MIN = -100000000;
    // public int cherryPickup(int[][] grid) {
    //     int row = grid.length;
    //     int col = grid[0].length;
    //     return recur(0, 0, col-1, grid, row, col);
    // }
    // int recur(int i , int j1, int j2, int[][] grid, int row, int col){
    //     if(j1<0 || j2<0 || j1>=col || j2>=col){
    //         return MIN;
    //     }
    //     if(i==row-1){
    //         if(j1==j2){
    //             return grid[i][j1];
    //         }else{
    //             return grid[i][j1]+grid[i][j2];
    //         }
    //     }
    //     int max = MIN;
    //     for(int cj1 = -1; cj1<=1; cj1++){
    //         for(int cj2 = -1; cj2<=1; cj2++){
    //             if(j1==j2){
    //                 max = Math.max(max, grid[i][j1]+recur(i+1, j1+cj1, j2+cj2, grid, row, col) );
    //             }else{
    //                 max = Math.max(max, grid[i][j1]+grid[i][j2]+recur(i+1,j1+cj1,j2+cj2,grid,row,col));
    //             }
    //         }
    //     }
    //     return max;
    // }


    // Memoization 3D DP
//     int MIN = -100000000;
//     public int cherryPickup(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         // since 3 parameters i, j1, j2 we need to create a 3d DP array to solve this
//         int[][][] dp = new int[row][col][col];
//         // populating the 3d dp array i created
//         for(int[][] arr: dp){
//             for(int[] rows: arr){
//                 Arrays.fill(rows, -1);
//             }
//         }
//         // passing the Dp array along with the recurssion fucntion
//         return recur(0, 0, col-1, dp, grid, row, col);
//     }
//     // entire function remains same just that the check if answer is present in the dp array
//     // and at last we store the answer int dp array;
//     int recur(int i , int j1, int j2, int[][][] dp, int[][] grid, int row, int col){
//         if(j1<0 || j2<0 || j1>=col || j2>=col){
//             return MIN;
//         }
// // check if answer already present in DP array?
//         if(dp[i][j1][j2]!=-1){
//             return dp[i][j1][j2];
//         }

//         if(i==row-1){
//             if(j1==j2){
//                 return grid[i][j1];
//             }else{
//                 return grid[i][j1]+grid[i][j2];
//             }
//         }

//         int max = MIN;
//         for(int cj1 = -1; cj1<=1; cj1++){
//             for(int cj2 = -1; cj2<=1; cj2++){
//                 // pass dp in function calls
//                 if(j1==j2){
//                     max = Math.max(max, grid[i][j1]+recur(i+1, j1+cj1, j2+cj2, dp, grid, row, col) );
//                 }else{
//                     max = Math.max(max, grid[i][j1]+grid[i][j2]+recur(i+1,j1+cj1,j2+cj2,dp, grid,row,col));
//                 }
//             }
//         }
//         // at last store the ans in dp array again and return
//         return dp[i][j1][j2]=max;
//     }

    // Tbaulation
    int MIN = -100000000;
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][col];

        //base case
        for(int j1 = 0; j1<col; j1++){
            for(int j2 = 0; j2<col; j2++){
                if(j1==j2){
                    dp[row-1][j1][j2] = grid[row-1][j1];
                }else{
                    dp[row-1][j1][j2] = grid[row-1][j1]+grid[row-1][j2];
                }
            }
        }

        // Express every state in for loop
        for(int i = row-2; i>=0; i--){
            for(int j1 = 0; j1<col; j1++ ){
                for(int j2 = 0; j2<col; j2++){

                    // copy recursion
                    int max = MIN;
                    for(int cj1 = -1; cj1<=1; cj1++){
                        for(int cj2 = -1; cj2<=1; cj2++){
                            // change the fucntion call to dp array
                            // also check if j>=0 and j<col that base case will be checked here
                            if(j1==j2){
                                if(j1+cj1<col && j2+cj2<col && j1+cj1>=0 && j2+cj2>=0){
                                    max = Math.max(max, grid[i][j1]+ dp[i+1][j1+cj1][j2+cj2] );
                                }else{
                                    max = Math.max(max, grid[i][j1] + MIN);
                                }
                            }else{
                                if(j1+cj1<col && j2+cj2<col && j1+cj1>=0 && j2+cj2>=0){
                                    max = Math.max(max, grid[i][j1]+grid[i][j2]+dp[i+1][j1+cj1][j2+cj2]);
                                }else{
                                    max = Math.max(max, grid[i][j1]+grid[i][j2]+MIN);
                                }
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        // int recursion you returned return recur(0, 0, col-1, dp, grid, row, col);
        // return same in terms of dp array
        return dp[0][0][col-1];
    }
}