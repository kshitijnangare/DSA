import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int prefix = 1;
		int suffix = 1;
		int max = Integer.MIN_VALUE;

		for(int i = 0; i<n; i++){
			if(prefix==0){prefix=1;}
			if(suffix==0){suffix=1;}

			prefix*=arr.get(i);
			suffix*=arr.get(n-i-1);
			max = Math.max(max, Math.max(prefix, suffix));
		}
		return max;
	}


}