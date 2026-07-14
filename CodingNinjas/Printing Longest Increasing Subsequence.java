import java.util.*;
public class Solution {
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        // Write Your Code Here
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
            hash[i]=i;
        }
        
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(arr[prev]<arr[i]){
                    if(dp[i] < dp[prev]+1){
                        dp[i]= dp[prev]+1;
                        hash[i]=prev;
                    }
                }
            }
        }
        
        int maxInd=0;
        int max = -1;
        for(int i =0; i<n; i++){
            if(max<dp[i]){
                maxInd = i;
                max = dp[i];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while(hash[maxInd]!=maxInd){
            list.add(arr[maxInd]);
            maxInd = hash[maxInd];
        }
        list.add(arr[maxInd]);
        Collections.reverse(list);
        return list;
    }
}