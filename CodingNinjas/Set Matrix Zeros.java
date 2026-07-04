import java.io.*;
import java.util.* ;

public class Solution {
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int row = matrix.length;
        int col = matrix[0].length;
        int col0 = 0;
        for(int i =0;i<row; i++){
            if(matrix[i][0]==0){
                col0=1;
            }
        }
        int row0=0;
        for(int j = 0;j<col;j++){
            if(matrix[0][j]==0){
                row0=1;
            }
        }

        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i =1; i<row; i++){
            if(matrix[i][0]==0){
                for(int j = 1; j<col; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j = 1; j<col; j++){
            if(matrix[0][j]==0){
                for(int i =1; i<row; i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(row0==1){
            for(int j = 0; j<col; j++){
                matrix[0][j]=0;
            }
        }
        if(col0==1){
            for(int i =0; i<row; i++){
                matrix[i][0]=0;
            }
        }
    }

}