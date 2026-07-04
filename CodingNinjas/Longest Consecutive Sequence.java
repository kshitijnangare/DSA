import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();
        for(int x: arr){
            set.add(x);
        }
        int res = 0;
        for(int x: set){
            if(!set.contains(x-1)){
                int z = x;
                int count = 1;
                while(set.contains(z+1)){
                    count++;
                    z++;
                }
                res = Math.max(count, res);
            }
        }
        return res;

    }
}