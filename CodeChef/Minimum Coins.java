import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{   
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
		// your code goes here
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        // int t = Integer.parseInt(br.readLine());
        // while (t-- > 0) {
            // solve(br, pw);
        // }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
       
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int[][] dp = new int[n+1][s+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int res = recur(n-1, s, arr, dp);
        pw.println(res == Integer.MAX_VALUE ? -1 : res);

        pw.flush();
        pw.close();
        br.close();
	}
    
    public static int recur(int i, int target, int[] arr, int[][] dp){
        if(i==0){
            if(target%arr[i]==0){
                return target/arr[i];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        
        // I have 2 options
        // either choose this coin or move ahead 
        int notpick = 0 + recur(i-1, target, arr, dp);
        int pick = Integer.MAX_VALUE;
        if(target>=arr[i]){
            int res = recur(i, target - arr[i], arr, dp);
            if(res != Integer.MAX_VALUE){
                pick = 1 + res;
            }
        }
        return dp[i][target]=Math.min(pick, notpick);
    } 
}
