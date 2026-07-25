import java.util.* ;
import java.io.*; 

public class Solution {

	public static int numberOfFlips(int a, int b) {
		// Write your code here.
		int xor = a ^ b;
        int ans = 0;
        while(xor>0){
            xor = xor & (xor-1);
            ans++;
        }
        return ans;
	}

}
