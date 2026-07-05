import java.util.*;
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		Arrays.sort(arr);
        int f = 0;
        int l = n-1;
        int fi = 0;
        int li=0;
        int fn= arr[f].length();
        int ln= arr[l].length();
        int count = 0;

        while(fi<fn && li<ln){
            if(arr[f].charAt(fi)==arr[l].charAt(li)){
                count++;
            }else{
                break;
            }
            fi++;
            li++;
        }
        String s = arr[f].substring(0, count);
        return s;
	}

}
