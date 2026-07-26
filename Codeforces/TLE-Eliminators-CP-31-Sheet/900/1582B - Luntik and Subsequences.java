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
        long n = Long.parseLong(br.readLine());
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ones = 0;
        int zeros = 0;
        for(int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            if(x==0){
                zeros++;
            }
            if(x==1){
                ones++;
            }
        }
        long ans = ones * (1L<<zeros);
        pw.println(ans);
        
    }
}