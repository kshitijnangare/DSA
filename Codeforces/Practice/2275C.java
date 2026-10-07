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
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
 
        pw.println(x+r + " " + y);
 
    }
}