import java.util.*;
public class Solution {
    public static List< Integer > divisibleSet(int []arr) {
        // Write your code here.
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
            hash[i]=i;
        }
        
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(arr[i]%arr[prev]==0){
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