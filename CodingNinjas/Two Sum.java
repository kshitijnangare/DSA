import java.util.*;

public class Solution {
	public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
		// Write your code here.
		ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
		Collections.sort(arr);

		int high = n-1;
		int low = 0;
		while(high>low){
			int sum = arr.get(low)+arr.get(high);
			if(sum == target){
				res.add(new Pair<>(arr.get(low), arr.get(high)));
				low++;
				high--;
			}else if(sum < target){
				low++;
			}else{
				high--;
			}
		}
		if (res.isEmpty()) {
            res.add(new Pair<>(-1, -1));
        }
		return res;
	}
}
