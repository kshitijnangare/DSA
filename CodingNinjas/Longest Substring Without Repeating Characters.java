import java.util.* ;
import java.io.*; 
public class Solution {
        
	public static int lengthOfLongestSubstring(String s) {
		// Write your code here.
        int max = 0;
        int low = 0;
        int high = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        while(high<s.length()){
            char c=s.charAt(high);
            if(set.contains(c)){
                set.remove(s.charAt(low));
                low++;
                count--;
            }else{
                set.add(c);
                high++;
                count++;
                max = Math.max(count,max);
            }
        }
        return max;
	}
}