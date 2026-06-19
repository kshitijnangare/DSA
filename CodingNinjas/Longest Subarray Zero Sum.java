import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.

		HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for(int i = 0; i<arr.size(); i++){
            prefixSum += arr.get(i);
            if(map.containsKey(prefixSum - 0)){
                int ind = map.get(prefixSum-0);
                maxLen = Math.max(maxLen, i-ind);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
        return maxLen;
	}
}