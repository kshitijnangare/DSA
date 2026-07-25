import java.util.* ;
import java.io.*; 
public class Solution {
    public static int occursOnce(int[] a, int n) {
        // Write your code here.
        int xor = 0;
        for(int x: a){
            xor = xor ^ x;
        }
        return xor;
    }
}
