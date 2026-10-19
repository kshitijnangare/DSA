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
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        // int sum = 0;
        // for(int i = 0; i<x; i++){
        //     sum+=arr[i];
        // }
        
        // pw.print(sum+" ");
        // int l = 1;
        // for(int r = x; r<n; r++){
        //     sum-=arr[l];
        //     sum+=arr[r];
        //     pw.print(sum+" ");
        // }
        // pw.println();
        
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i-x) {
                dq.pollFirst();
            }
            
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
    
            if (i >= x - 1) {
                pw.print(arr[dq.peekFirst()] + " ");
            }
        }
        pw.println();
    }
}