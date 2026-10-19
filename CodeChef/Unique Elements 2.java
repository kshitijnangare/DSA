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
            solve(br, pw);
        // }

        pw.flush();
        pw.close();
        br.close();

	
	    
	}

    public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int n = Integer.parseInt(line.trim());

        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = null;
        
        for(int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                String nextLine = br.readLine();
                if (nextLine == null) break;
                st = new StringTokenizer(nextLine);
            }
            
            if (st != null && st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (!set.contains(x)) {
                    pw.print(x + " ");
                    set.add(x);
                }
            }
        }
        pw.println();
        
    }
}