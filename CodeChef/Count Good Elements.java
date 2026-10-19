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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;
        pq.add(arr[0]);
        for(int i = 1; i<n; i++){
            if(arr[i]<pq.peek()){
                count++;
            }
            pq.add(arr[i]);
            if(i>=5){
                pq.remove(arr[i-5]);
            }
        }
        pw.println(count);
    }
}