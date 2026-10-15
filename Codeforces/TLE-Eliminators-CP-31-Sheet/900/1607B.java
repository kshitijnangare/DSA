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
        long x = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        long currcord = x;
        long rem = n % 4;
        long start = n - rem + 1;
        for(long i = start; i<=n; i++){
            int dir = (currcord%2 == 0) ? -1 : 1;
            long adder = dir * i;
            currcord = currcord + adder;
        }
        pw.println(currcord);
    }
}

// my thinking 

// brute force 
// manually calculate the n steps. but the problem is time given is 1 seconds
// 1 sec = 10^8 ops
// but we have long = 10^14
// we will get TLE for sure

// optimal solution
// if we observe then after 4th jump the grasshoper comes to same position
// no matter how long he jumps.
// so we need to calculate for the last max 3 jumps only