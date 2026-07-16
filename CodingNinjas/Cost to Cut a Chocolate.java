import java.util.* ;
import java.io.*; 
public class Solution {
    public static int cost(int n, int c, int cuts[]) {

        // Write your code here..
        int len = cuts.length;
        int[] copy = Arrays.copyOf(cuts, len+2);
        len = copy.length;
        copy[len-1]=0;
        copy[len-2]=n;
        Arrays.sort(copy);
        int[][] dp = new int[len][len];
        
        for(int j = 0; j<len; j++){
            for(int i = len-1; i>j; i--){
                dp[i][j]=0;
            }
        }

        // int recursion i went from 1 to len-2
        // here it will b reverse
        for(int i = len-2; i>=1; i--){
            // j went from len-2 to i. here goes reverese
            for(int j = i; j<=len-2; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k<=j; k++){
                    int cost = copy[j+1] - copy[i-1];
                    int firstPartition = dp[i][k-1];
                    int secondPartition = dp[k+1][j];
                    int totalCost = cost + firstPartition + secondPartition;
                    min = Math.min(min, totalCost);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][len-2];
    }

}