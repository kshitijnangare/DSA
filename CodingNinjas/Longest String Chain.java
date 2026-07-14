import java.util.*;
public class Solution {
    public static int longestStrChain(String[] arr) {
        // Write your code here.
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i]=1;
        }
        int maxLen = 0;
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(compare(arr[prev], arr[i])){
                    if(dp[i] < dp[prev]+1){
                        dp[i]= dp[prev]+1;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    static boolean compare(String s1, String s2){
        if(s2.length() != s1.length() + 1) return false;   
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length();
    }
}