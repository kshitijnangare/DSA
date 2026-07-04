import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		int n = permutation.size();
        int breakInd = n;
        for(int i = n-2; i>=0; i--){
            if(permutation.get(i)<permutation.get(i+1)){
                breakInd=i;
                break;
            }
        }
        
        if(breakInd==n){
            Collections.sort(permutation);
            return permutation;
        }
        
        int immediateGreater = Integer.MAX_VALUE;
        int swapInd = -1;
        for(int i = breakInd+1; i<n; i++){
            if(permutation.get(i)>permutation.get(breakInd)){
                if(immediateGreater>permutation.get(i)){
                    immediateGreater = permutation.get(i);
                    swapInd = i;
                }
            }
        }
        
        if(swapInd==-1){return permutation;}
        int t = permutation.get(swapInd);
        permutation.set(swapInd, permutation.get(breakInd));
        permutation.set(breakInd, t);
        
        Collections.sort(permutation.subList(breakInd + 1, n));
        return permutation;
	}
}
