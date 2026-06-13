import java.util.* ;
import java.io.*; 
public class Solution {
	// recursion 
    // static int MIN = -100000000;
    // public static int maximumChocolates(int r, int c,int[][] grid) {
    //     return recur(0, 0, c-1, grid, r, c);
    // }
    // static int recur(int i , int j1, int j2, int[][] grid, int r, int c){
    //     if(j1<0 || j2<0 || j1>=c || j2>=c){
    //         return MIN;
    //     }
    //     if(i==r-1){
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
    //                 max = Math.max(max, grid[i][j1]+recur(i+1, j1+cj1, j2+cj2, grid, r, c) );
    //             }else{
    //                 max = Math.max(max, grid[i][j1]+grid[i][j2]+recur(i+1,j1+cj1,j2+cj2,grid,r,c));
    //             }
    //         }
    //     }
    //     return max;
    // }


    // Memoization 3D DP
//     static int MIN = -100000000;
//     public static int maximumChocolates(int r, int c,int[][] grid) {

//         // since 3 parameters i, j1, j2 we need to create a 3d DP array to solve this
//         int[][][] dp = new int[r][c][c];
//         // populating the 3d dp array i created
//         for(int[][] arr: dp){
//             for(int[] rs: arr){
//                 Arrays.fill(rs, -1);
//             }
//         }
//         // passing the Dp array along with the recurssion fucntion
//         return recur(0, 0, c-1, dp, grid, r, c);
//     }
//     // entire function remains same just that the check if answer is present in the dp array
//     // and at last we store the answer int dp array;
//     static int recur(int i , int j1, int j2, int[][][] dp, int[][] grid, int r, int c){
//         if(j1<0 || j2<0 || j1>=c || j2>=c){
//             return MIN;
//         }
// // check if answer already present in DP array?
//         if(dp[i][j1][j2]!=-1){
//             return dp[i][j1][j2];
//         }

//         if(i==r-1){
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
//                     max = Math.max(max, grid[i][j1]+recur(i+1, j1+cj1, j2+cj2, dp, grid, r, c) );
//                 }else{
//                     max = Math.max(max, grid[i][j1]+grid[i][j2]+recur(i+1,j1+cj1,j2+cj2,dp, grid,r,c));
//                 }
//             }
//         }
//         // at last store the ans in dp array again and return
//         return dp[i][j1][j2]=max;
//     }

    // Tbaulation
    static int MIN = -100000000;
    public static int maximumChocolates(int r, int c,int[][] grid) {

        int[][][] dp = new int[r][c][c];

        //base case
        for(int j1 = 0; j1<c; j1++){
            for(int j2 = 0; j2<c; j2++){
                if(j1==j2){
                    dp[r-1][j1][j2] = grid[r-1][j1];
                }else{
                    dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
                }
            }
        }

        // Express every state in for loop
        for(int i = r-2; i>=0; i--){
            for(int j1 = 0; j1<c; j1++ ){
                for(int j2 = 0; j2<c; j2++){

                    // copy recursion
                    int max = MIN;
                    for(int cj1 = -1; cj1<=1; cj1++){
                        for(int cj2 = -1; cj2<=1; cj2++){
                            // change the fucntion call to dp array
                            // also check if j>=0 and j<c that base case will be checked here
                            if(j1==j2){
                                if(j1+cj1<c && j2+cj2<c && j1+cj1>=0 && j2+cj2>=0){
                                    max = Math.max(max, grid[i][j1]+ dp[i+1][j1+cj1][j2+cj2] );
                                }else{
                                    max = Math.max(max, grid[i][j1] + MIN);
                                }
                            }else{
                                if(j1+cj1<c && j2+cj2<c && j1+cj1>=0 && j2+cj2>=0){
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
        // int recursion you returned return recur(0, 0, c-1, dp, grid, r, c);
        // return same in terms of dp array
        return dp[0][0][c-1];
    }
}