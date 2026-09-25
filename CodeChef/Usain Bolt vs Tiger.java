import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    solve(br, pw);
		}
		pw.flush();
		pw.close();
		br.close();
	}
	public static void solve(BufferedReader br, PrintWriter pw) throws java.lang.Exception, IOException{
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int sbolt = Integer.parseInt(st.nextToken());
	    int stiger = Integer.parseInt(st.nextToken()) + sbolt;
	    int a = Integer.parseInt(st.nextToken());
	    int u = Integer.parseInt(st.nextToken());
	    
	    double tbolt = (double) sbolt/u;
	    double ttiger = Math.sqrt((2.0 * stiger) / a);
	    if(tbolt<ttiger){
	        pw.println("Bolt");
	    }else{
	        pw.println("Tiger");
	    }
	}
}
