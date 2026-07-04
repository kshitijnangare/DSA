import java.util.*;
public class Solution {
    public static int[] spiralMatrix(int [][]matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int right = col-1;
        int left = 0;
        int bottom = row-1;
        int[] res = new int[row*col];
        int ind = 0;
        while(top<=bottom && left<=right){
            //top row
            for(int i = left; i<=right; i++){
                res[ind] = matrix[top][i];
                ind++;
            }
            top++;
            //right col
            for(int i = top; i<=bottom; i++){
                res[ind]=matrix[i][right];
                ind++;
            }
            right--;
            //bottom row
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    res[ind]=matrix[bottom][i];
                    ind++;
                }
            }
            bottom--;
            //left most col
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    res[ind]=matrix[i][left];
                    ind++;
                }
                left++;
            }
        }
        return res;
    }
}