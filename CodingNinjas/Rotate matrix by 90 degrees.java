import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix){
		// Write your code here.
		transpose(matrix);
        int n = matrix.size();
        for(int j = 0;j<n; j++){
            int u = 0; int d = n-1;
            while(u<d){
                int t = matrix.get(u).get(j);
                matrix.get(u).set(j, matrix.get(d).get(j));
                matrix.get(d).set(j, t);
                u++;
                d--;
            }
        }
        return matrix;
    }
    static void transpose(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int t = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, t);
            }
        }
    }
}