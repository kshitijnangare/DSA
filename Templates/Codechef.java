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
        // Example of reading a single integer
        // int n = Integer.parseInt(br.readLine());

        // Example of reading a line of space-separated integers
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int a = Integer.parseInt(st.nextToken());
        // int b = Integer.parseInt(st.nextToken());
        // int c = Integer.parseInt(st.nextToken());

        // Example of reading an array of integers
        // int[] arr = new int[n];
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // for (int i = 0; i < n; i++) {
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }

        // Example of reading a string
        // String s = br.readLine();

        // Example of printing output
        // pw.println("Hello World!");
        // pw.println(result);

    }
}