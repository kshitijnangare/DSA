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
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n==1){
            pw.println(0);
            return;
        }
        int count=0;
        for(int i = n-2; i>=0; i--){
            while (arr[i]>=arr[i+1] && arr[i]>0) {
                arr[i] /= 2;
                count++;
            }

            if (arr[i]>=arr[i+1]) {
                pw.println(-1);
                return;
            }
        }
        pw.println(count);
    }
}

// thinking
// every number continuously divided by 2 boils down to 1-->0
// x / 2 = 3 when x multiple of {6 7} 