import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{   
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br, pw);
        }

        pw.flush();
        pw.close();
        br.close();
	}

    public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] prefixsum = new long[n+1];
        prefixsum[0]=0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            prefixsum[i+1]=prefixsum[i]+arr[i];
        }

        // do the modulo
        for(int i = 0; i<n+1; i++){
            prefixsum[i]=prefixsum[i]%k;
        }

        long[] freq = new long[k];
        long ans = 0;
        for(int r=1; r<=n; r++) {
            int j = r-k-1;
            if (j >= 0) {
                // int rem = (int)(prefixsum[j] % k);
                int rem = (int)(prefixsum[j]);
                freq[rem]++;
            }

            // int currentRem = (int) (pref[r] % k);
            int currem = (int) (prefixsum[r]);
            ans += freq[currem];
        }
        pw.println(ans);
    }
}


// my thinking

// max time complexity --> O(nlogn) --> n^2 goes to 10^19 ops and time = 2 sec not possible

// brute force will not work in time complexity
// 1. generate all possible subarrays with size > k
// 2. find sum of all generated subarrays
// 3. find total sum%k ==0 

// optimization
// i think we need to use prefix and suffix arrays. let me try first
// suppose I have
// 02 01 03 07 09 14 06 03 02 --> arr
// 02 03 06 13 22 36 42 45 47 --> pre
// 47 45 44 41 34 25 01 05 02 --> suf

// there are 2 conditions
// 1. r - l + 1 > k
// 2. sum % k ==0
// // now sum[l,r] = n - pref[l] - suff[r] = pref[r] - pref[l-1]
// // but if we try to find all sum[l,r] its equivalent to generating all subarrays
// // need to optimize it
// (pref[r] - pref[l-1]) % k == 0   eg. (13 - 5) % 2 ==0
// means pref[r] % k == pref[l-1] % k  (13 % 2 == 5 % 2)
// lets store pref % k instead of sum
// lets make their frequency count
// suppose there are 2 counts of pref % k == 2
// then there is an single array whose pref[r]-pref[l-1] % k ==0
// but there is also length conditions
// what if i store length along with count? like index of where the sum is found
// we have condition r -l + 1 > k ==> r-k+1>l

// suppose the left is l then we need strictly those r whose r-k+1>l
// lets maintain array of hashmaps
// freq of prefixsum upto the index r-k+1
