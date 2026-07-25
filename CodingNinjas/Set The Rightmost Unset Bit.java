public class Solution {
    public static int setBits(int N){
        // Write your code here.
        if( (N & (N+1))==0 ){
            return N;
        }
        N = N | (N+1);
        return N;
    }
}
