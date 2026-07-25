import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
		int n = arr.size();
		int psize = (1<<n);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for(int i = 0; i<psize; i++){
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = 0; j<n; j++){
				if((i & (1<<j))!=0){
					temp.add(arr.get(j));
				}
			}
			res.add(temp);
		}
		return res;
	}
}

